package com.in.bucketStore.testStore.model.request;

import com.in.bucketStore.testStore.model.enums.ProductSearchOption;
import com.in.bucketStore.testStore.model.enums.SortOption;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSearchRequest {

    private ProductSearchOption productSearchOption;
    private SortOption sortOption;
    private long limit;
}
