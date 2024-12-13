package com.in.bucketStore.testStore.entity;

import com.in.bucketStore.testStore.model.dto.ProductOrderDetailDto;
import com.in.bucketStore.testStore.model.enums.ProductOrderDetailStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Table(schema = "bucket_db", name = "product_order_detail")
public class ProductOrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "order_id")
    private String productOrderId;

    @Column(name = "product_detail_id")
    private String productDetailId;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private ProductOrderDetailStatus status;

    @Column(name = "price")
    private long price;

    public static ProductOrderDetailDto toDTO(ProductOrderDetail entity) {
        return ProductOrderDetailDto.builder()
                .id(entity.getId())
                .productDetailId(entity.getProductDetailId())
                .productOrderId(entity.getProductOrderId())
                .status(entity.getStatus())
                .price(entity.getPrice())
                .build();
    }
}
