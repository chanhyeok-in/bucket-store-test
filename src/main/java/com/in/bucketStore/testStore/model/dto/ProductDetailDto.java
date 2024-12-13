package com.in.bucketStore.testStore.model.dto;

import com.in.bucketStore.testStore.model.enums.ProductDetailStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDetailDto {

    private String id;
    private String productId;
    private ProductDetailStatus status;
    private long stockQuantity;
    private String color;
    private String size;
    private long price;
    private boolean deleted;

}
