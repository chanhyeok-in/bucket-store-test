package com.in.bucketStore.testStore.model.request;

import com.in.bucketStore.testStore.model.enums.ProductOrderSearchOption;
import com.in.bucketStore.testStore.model.enums.SortOption;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOrderSearchRequest {

    private ProductOrderSearchOption productOrderSearchOption;
    private SortOption sortOption;
    private long limit;
}
