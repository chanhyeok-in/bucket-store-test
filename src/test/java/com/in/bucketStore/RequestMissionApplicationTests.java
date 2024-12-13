package com.in.bucketStore;

import com.in.bucketStore.testStore.controller.ProductController;
import com.in.bucketStore.testStore.controller.ProductOrderController;
import com.in.bucketStore.testStore.entity.ProductOrderDetail;
import com.in.bucketStore.testStore.model.enums.ProductOrderSearchOption;
import com.in.bucketStore.testStore.model.enums.ProductSearchOption;
import com.in.bucketStore.testStore.model.enums.SortOption;
import com.in.bucketStore.testStore.model.request.ProductOrderRequest;
import com.in.bucketStore.testStore.model.request.ProductOrderSearchRequest;
import com.in.bucketStore.testStore.model.request.ProductSearchRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class bucketStoreTestApplicationTests {
    @Autowired
    ProductOrderController productOrderController;
    @Autowired
    ProductController productController;

    @Test
    void getOrders() {
        ProductOrderSearchRequest request = new ProductOrderSearchRequest();
        request.setProductOrderSearchOption(ProductOrderSearchOption.CREATED_AT);
        request.setSortOption(SortOption.DESC);
        request.setLimit(2);
        productOrderController.getProductOrders(request);
    }

    @Test
    void getOrder() {
        String productOrderId = "54b0841f-0f83-4423-a954-18348eb90ca1";
        productOrderController.getProductOrder(productOrderId);
    }

    @Test
    void getProducts() {
        ProductSearchRequest request = new ProductSearchRequest();
        request.setProductSearchOption(ProductSearchOption.CATEGORY);
        request.setSortOption(SortOption.ASC);
        request.setLimit(2);
        productController.getProducts(request);
    }

    @Test
    void addOrder() throws Exception {
        ProductOrderRequest request = new ProductOrderRequest();
        request.setUserId("USERID-1");
        request.setLocation("서울특별시 종로구 12-2");
        request.setProductDetailIdList(List.of(new String[]{"pdid-3", "pdid-5"}));
        productOrderController.addProductOrder(request);
    }

    @Test
    void cancelOrderDetail() throws Exception {
        String id = "0d7b0edc-d129-4c20-b9ef-e06c7c457288";
        productOrderController.cancelProductOrderDetail(id);
    }
}
