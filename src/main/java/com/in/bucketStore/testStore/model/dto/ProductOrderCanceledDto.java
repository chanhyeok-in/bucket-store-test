package com.in.bucketStore.testStore.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductOrderCanceledDto {

    private String id;
    private String productOrderId;
    private String productOrderDetailId;
    private long refundAmount;
    private long shippingFee;
}
