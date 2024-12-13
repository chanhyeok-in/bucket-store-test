package com.in.bucketStore.testStore.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductOrderDetail is a Querydsl query type for ProductOrderDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductOrderDetail extends EntityPathBase<ProductOrderDetail> {

    private static final long serialVersionUID = -1323408247L;

    public static final QProductOrderDetail productOrderDetail = new QProductOrderDetail("productOrderDetail");

    public final StringPath id = createString("id");

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final StringPath productDetailId = createString("productDetailId");

    public final StringPath productOrderId = createString("productOrderId");

    public final EnumPath<com.in.bucketStore.testStore.model.enums.ProductOrderDetailStatus> status = createEnum("status", com.in.bucketStore.testStore.model.enums.ProductOrderDetailStatus.class);

    public QProductOrderDetail(String variable) {
        super(ProductOrderDetail.class, forVariable(variable));
    }

    public QProductOrderDetail(Path<? extends ProductOrderDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductOrderDetail(PathMetadata metadata) {
        super(ProductOrderDetail.class, metadata);
    }

}

