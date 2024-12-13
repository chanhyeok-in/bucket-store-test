package com.in.bucketStore.testStore.model.dto;

import com.in.bucketStore.testStore.entity.ProductOrder;
import com.in.bucketStore.testStore.model.enums.ProductOrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ProductOrderDto {

    private String id;
    private String userId;
    private ProductOrderStatus status;
    private String location;

    private List<ProductOrderDetailDto> productOrderDetailDtoList;
    private List<ProductOrderCanceledDto> productOrderCanceledDtoList;

    public static ProductOrder toEntity(ProductOrderDto dto) {
        return ProductOrder.builder()
                .id(dto.getId())
                .userId(dto.getUserId())
                .status(dto.getStatus())
                .location(dto.getLocation())
                .build();
    }
}
