package com.in.bucketStore.testStore.Service;

import com.in.bucketStore.testStore.entity.ProductDetail;
import com.in.bucketStore.testStore.entity.ProductOrder;
import com.in.bucketStore.testStore.entity.ProductOrderCanceled;
import com.in.bucketStore.testStore.entity.ProductOrderDetail;
import com.in.bucketStore.testStore.model.dto.ProductDetailDto;
import com.in.bucketStore.testStore.model.dto.ProductOrderDetailDto;
import com.in.bucketStore.testStore.model.dto.ProductOrderDto;
import com.in.bucketStore.testStore.model.enums.ProductDetailStatus;
import com.in.bucketStore.testStore.model.enums.ProductOrderDetailStatus;
import com.in.bucketStore.testStore.model.enums.ProductOrderStatus;
import com.in.bucketStore.testStore.model.request.ProductOrderRequest;
import com.in.bucketStore.testStore.model.request.ProductOrderSearchRequest;
import com.in.bucketStore.testStore.repository.ProductDetailRepository;
import com.in.bucketStore.testStore.repository.ProductOrderCanceledRepository;
import com.in.bucketStore.testStore.repository.ProductOrderDetailRepository;
import com.in.bucketStore.testStore.repository.ProductOrderRepository;
import com.in.bucketStore.testStore.repositorySupport.ProductOrderCanceledRepositorySupport;
import com.in.bucketStore.testStore.repositorySupport.ProductOrderDetailRepositorySupport;
import com.in.bucketStore.testStore.repositorySupport.ProductOrderRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class ProductOrderService {

    private static final long REFUND_SHIPPING_FEE = 3_000;
    private final ProductDetailRepository productDetailRepository;
    private final ProductOrderRepository productOrderRepository;
    private final ProductOrderCanceledRepository productOrderCanceledRepository;
    private final ProductOrderDetailRepository productOrderDetailRepository;
    private final ProductOrderRepositorySupport productOrderRepositorySupport;
    private final ProductOrderCanceledRepositorySupport productOrderCanceledRepositorySupport;
    private final ProductOrderDetailRepositorySupport productOrderDetailRepositorySupport;

    public List<ProductOrderDto> getProductOrders(ProductOrderSearchRequest request) {
        List<ProductOrder> productOrderList = productOrderRepositorySupport.findByOrderBy(request);

        return productOrderList.stream().map(ProductOrder::toDTO).toList();
    }

    public ProductOrderDto getProductOrder(String id) {
        ProductOrder productOrder = productOrderRepository.findById(id).orElseThrow();
        ProductOrderDto productOrderDto = ProductOrder.toDTO(productOrder);
        List<ProductOrderDetail> productOrderList = productOrderDetailRepositorySupport.findByProductOrderId(id);
        List<ProductOrderCanceled> productOrderCanceledList = productOrderCanceledRepositorySupport.findByProductOrderId(id);
        productOrderDto.setProductOrderDetailDtoList(productOrderList.stream().map(ProductOrderDetail::toDTO).toList());
        productOrderDto.setProductOrderCanceledDtoList(productOrderCanceledList.stream().map(ProductOrderCanceled::toDTO).toList());
        return productOrderDto;
    }

    public void addProductOrder(ProductOrderRequest request) throws Exception {
        List<ProductOrderDetail> productOrderDetailList = new ArrayList<ProductOrderDetail>();
        if (request.getLocation() == null || request.getUserId() == null || request.getProductDetailIdList() == null) {
            throw new Exception("Invalid Parameter");
        }

        ProductOrder productOrder = ProductOrder.builder()
                .userId(request.getUserId())
                .location(request.getLocation())
                .status(ProductOrderStatus.PURCHASED)
                .build();
        ProductOrder newProductOrder = productOrderRepository.save(productOrder);

        request.getProductDetailIdList().forEach(productDetailId ->
                {
                    ProductDetail checkProductDetail = productDetailRepository.findById(productDetailId).orElseThrow();
                    ProductDetailDto productDetailDto = ProductDetail.toDTO(checkProductDetail);
                    if (ProductDetailStatus.ING.equals(productDetailDto.getStatus()) && productDetailDto.getStockQuantity() > 0) {
                        minusStockQuantity(productDetailDto);
                        ProductOrderDetail productOrderDetail = ProductOrderDetail.builder()
                                .productDetailId(productDetailDto.getId())
                                .productOrderId(newProductOrder.getId())
                                .price(productDetailDto.getPrice())
                                .status(ProductOrderDetailStatus.ING)
                                .build();
                        productOrderDetailList.add(productOrderDetail);
                    } else {
                        try {
                            throw new Exception("Product Detail is not Available");
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );

        productOrderDetailRepository.saveAll(productOrderDetailList);
    }


    public void minusStockQuantity(ProductDetailDto productDetailDto) {
        if (productDetailDto.getStockQuantity() - 1 < 0) {
            productDetailDto.setStatus(ProductDetailStatus.SOLD_OUT);
        }
        ProductDetail newProductDetail = ProductDetail.builder()
                .id(productDetailDto.getId())
                .productId(productDetailDto.getProductId())
                .size(productDetailDto.getSize())
                .color(productDetailDto.getColor())
                .deleted(productDetailDto.isDeleted())
                .price(productDetailDto.getPrice())
                .stockQuantity(productDetailDto.getStockQuantity() - 1)
                .status(productDetailDto.getStatus())
                .build();
        productDetailRepository.save(newProductDetail);
    }

    public void plusStockQuantity(ProductDetailDto productDetailDto) {
        if (productDetailDto.getStockQuantity() == 0) {
            productDetailDto.setStatus(ProductDetailStatus.ING);
        }
        ProductDetail newProductDetail = ProductDetail.builder()
                .id(productDetailDto.getId())
                .productId(productDetailDto.getProductId())
                .size(productDetailDto.getSize())
                .color(productDetailDto.getColor())
                .deleted(productDetailDto.isDeleted())
                .price(productDetailDto.getPrice())
                .stockQuantity(productDetailDto.getStockQuantity() + 1)
                .status(productDetailDto.getStatus())
                .build();
        productDetailRepository.save(newProductDetail);
    }

    public void cancelProductOrderDetail(String productOrderDetailId) {
        ProductOrderDetail productOrderDetail = productOrderDetailRepository.findById(productOrderDetailId).orElseThrow();
        ProductOrderDetailDto productOrderDetailDto = ProductOrderDetail.toDTO(productOrderDetail);
        ProductDetail productDetail = productDetailRepository.findById(productOrderDetailDto.getProductDetailId()).orElseThrow();
        ProductDetailDto productDetailDto = ProductDetail.toDTO(productDetail);
        if (productOrderDetail.getStatus().equals(ProductOrderDetailStatus.ING)) {
            updateOrderDetailStatus(productOrderDetailDto);
            ProductOrderCanceled productOrderCanceled = ProductOrderCanceled.builder()
                    .productOrderId(productOrderDetailDto.getProductOrderId())
                    .productOrderDetailId(productOrderDetailDto.getProductDetailId())
                    .refundAmount(productOrderDetailDto.getPrice() - REFUND_SHIPPING_FEE)
                    .shippingFee(REFUND_SHIPPING_FEE)
                    .build();
            plusStockQuantity(productDetailDto);
            productOrderCanceledRepository.save(productOrderCanceled);
        } else {
            try {
                throw new Exception("Product Order Detail is not In-Progress");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void updateOrderDetailStatus(ProductOrderDetailDto productOrderDetailDto) {

        ProductOrderDetail newProductOrderDetail = ProductOrderDetail.builder()
                .id(productOrderDetailDto.getId())
                .productOrderId(productOrderDetailDto.getProductOrderId())
                .productDetailId(productOrderDetailDto.getProductDetailId())
                .price(productOrderDetailDto.getPrice())
                .status(ProductOrderDetailStatus.CANCELED)
                .build();
        productOrderDetailRepository.save(newProductOrderDetail);
    }
}
