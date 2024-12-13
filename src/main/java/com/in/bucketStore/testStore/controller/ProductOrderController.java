package com.in.bucketStore.testStore.controller;

import com.in.bucketStore.testStore.Service.ProductOrderService;
import com.in.bucketStore.testStore.model.dto.ProductOrderDto;
import com.in.bucketStore.testStore.model.request.ProductOrderRequest;
import com.in.bucketStore.testStore.model.request.ProductOrderSearchRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    @Operation(summary = "Get Products Info", description = " 입력된 정렬기준(STATUS, UID, CREATED_AT, UPDATED_AT)과 순서(ASC, DESC)로 상품 정보를 limit(>0) 개 조회")
    public List<ProductOrderDto> getProductOrders(@ModelAttribute ProductOrderSearchRequest request) {
        return productOrderService.getProductOrders(request);
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    @Operation(summary = "Get Products Info", description = "입력된 주문ID에 대한 상세정보 조회")
    public ProductOrderDto getProductOrder(@RequestParam(value = "id") String id) {
        return productOrderService.getProductOrder(id);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    @Operation(summary = "Add Product Order", description = "주문자 ID, 배송지, 상품 상세ID LIST로 주문 생성")
    public void addProductOrder(@RequestBody ProductOrderRequest request) throws Exception {
        productOrderService.addProductOrder(request);
    }

    @RequestMapping(value = "/orders/cancel/{productOrderDetailId}", method = RequestMethod.POST)
    @Operation(summary = "Cancel Order Detail", description = "주문 상세 ID 값으로 상품을 취소")
    public void cancelProductOrderDetail(@PathVariable("productOrderDetailId") String productOrderDetailId) throws Exception {
        productOrderService.cancelProductOrderDetail(productOrderDetailId);
    }
}
