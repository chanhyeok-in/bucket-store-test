package com.in.bucketStore.testStore.entity;

import com.in.bucketStore.testStore.model.dto.ProductDetailDto;
import com.in.bucketStore.testStore.model.enums.ProductDetailStatus;
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
@Table(schema = "bucket_db", name = "product_detail")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private ProductDetailStatus status;

    @Column(name = "stock_quantity")
    private long stockQuantity;

    @Column(name = "color")
    private String color;

    @Column(name = "size")
    private String size;

    @Column(name = "price")
    private long price;

    @Column(name = "deleted")
    private boolean deleted;

    public static ProductDetailDto toDTO(ProductDetail entity) {
        return ProductDetailDto.builder()
                .id(entity.getId())
                .productId(entity.getProductId())
                .status(entity.getStatus())
                .stockQuantity(entity.getStockQuantity())
                .color(entity.getColor())
                .size(entity.getSize())
                .price(entity.getPrice())
                .build();
    }
}
