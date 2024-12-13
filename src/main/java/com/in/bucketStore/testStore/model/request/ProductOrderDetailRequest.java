package com.in.bucketStore.testStore.model.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductOrderDetailRequest {

    private String id;
    private String advertiseContent;
    private BigDecimal amount;
    private BigDecimal accVolume;
    private BigDecimal point;

}
