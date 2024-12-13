package com.in.bucketStore.testStore.model.request;

import com.in.bucketStore.testStore.model.dto.ProductDetailDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductOrderRequest {
    private String userId;
    private String location;
    private List<String> productDetailIdList;
}
