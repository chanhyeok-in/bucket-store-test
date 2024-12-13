package com.in.bucketStore.testStore.model.dto;

import com.in.bucketStore.testStore.model.enums.ProductStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ProductDto {

    private String id;
    private String name;
    private ProductStatus status;
    private String category;
    private String description;

    private List<ProductDetailDto> productDetailDtoList;
}
