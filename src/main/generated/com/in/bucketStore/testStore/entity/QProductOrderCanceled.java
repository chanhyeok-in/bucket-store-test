package com.in.bucketStore.testStore.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductOrderCanceled is a Querydsl query type for ProductOrderCanceled
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductOrderCanceled extends EntityPathBase<ProductOrderCanceled> {

    private static final long serialVersionUID = -1652907311L;

    public static final QProductOrderCanceled productOrderCanceled = new QProductOrderCanceled("productOrderCanceled");

    public final StringPath createdAt = createString("createdAt");

    public final StringPath id = createString("id");

    public final StringPath productOrderDetailId = createString("productOrderDetailId");

    public final StringPath productOrderId = createString("productOrderId");

    public final NumberPath<Long> refundAmount = createNumber("refundAmount", Long.class);

    public final NumberPath<Long> shippingFee = createNumber("shippingFee", Long.class);

    public QProductOrderCanceled(String variable) {
        super(ProductOrderCanceled.class, forVariable(variable));
    }

    public QProductOrderCanceled(Path<? extends ProductOrderCanceled> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductOrderCanceled(PathMetadata metadata) {
        super(ProductOrderCanceled.class, metadata);
    }

}

