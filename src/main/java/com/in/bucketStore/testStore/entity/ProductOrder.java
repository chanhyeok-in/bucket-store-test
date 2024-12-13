package com.in.bucketStore.testStore.entity;

import com.in.bucketStore.testStore.model.dto.ProductOrderDto;
import com.in.bucketStore.testStore.model.enums.ProductOrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Table(schema = "bucket_db", name = "product_order")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "uid")
    private String userId;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private ProductOrderStatus status;

    @Column(name = "location")
    private String location;

    @Column(name = "created_at")
    @CreationTimestamp
    private String createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private String updatedAt;

    public static ProductOrderDto toDTO(ProductOrder entity) {
        return ProductOrderDto.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .status(entity.getStatus())
                .location(entity.getLocation())
                .build();
    }
}
