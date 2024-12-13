package com.in.bucketStore.testStore.model.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDetailRequest {

    private String _id;
    private String pool;
    private String trx_id;
    private String sender;
    private String sqrtPriceX64;
    private BigDecimal totalUSDVolume;
    private String tokenA;
    private String tokenB;
    private String time;

}
