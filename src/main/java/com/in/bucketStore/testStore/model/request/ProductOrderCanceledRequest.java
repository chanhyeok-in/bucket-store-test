package com.in.bucketStore.testStore.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOrderCanceledRequest {

    private String id;
    private String userId;
    private String productOrderId;
}
