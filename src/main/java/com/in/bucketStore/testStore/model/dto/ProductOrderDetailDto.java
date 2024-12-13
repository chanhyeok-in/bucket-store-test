package com.in.bucketStore.testStore.model.dto;

import com.in.bucketStore.testStore.model.enums.ProductOrderDetailStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductOrderDetailDto {

    private String id;
    private String productOrderId;
    private String productDetailId;
    private ProductOrderDetailStatus status;
    private long price;

}
