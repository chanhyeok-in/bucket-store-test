package com.in.bucketStore.testStore.entity;

import com.in.bucketStore.testStore.model.dto.ProductOrderCanceledDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Table(schema = "bucket_db", name = "product_order_canceled")
public class ProductOrderCanceled {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "product_order_id")
    private String productOrderId;

    @Column(name = "product_order_detail_id")
    private String productOrderDetailId;

    @Column(name = "refund_amount")
    private long refundAmount;

    @Column(name = "shipping_fee")
    private long shippingFee;

    @Column(name = "created_at")
    @CreationTimestamp
    private String createdAt;

    public static ProductOrderCanceledDto toDTO(ProductOrderCanceled entity) {
        return ProductOrderCanceledDto.builder()
                .id(entity.getId())
                .productOrderId(entity.getProductOrderId())
                .productOrderDetailId(entity.getProductOrderDetailId())
                .refundAmount(entity.getRefundAmount())
                .shippingFee(entity.getShippingFee())
                .build();
    }
}
