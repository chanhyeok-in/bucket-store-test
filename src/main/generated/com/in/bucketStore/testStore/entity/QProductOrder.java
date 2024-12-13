package com.in.bucketStore.testStore.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductOrder is a Querydsl query type for ProductOrder
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductOrder extends EntityPathBase<ProductOrder> {

    private static final long serialVersionUID = 1040142872L;

    public static final QProductOrder productOrder = new QProductOrder("productOrder");

    public final StringPath createdAt = createString("createdAt");

    public final StringPath id = createString("id");

    public final StringPath location = createString("location");

    public final EnumPath<com.in.bucketStore.testStore.model.enums.ProductOrderStatus> status = createEnum("status", com.in.bucketStore.testStore.model.enums.ProductOrderStatus.class);

    public final StringPath updatedAt = createString("updatedAt");

    public final StringPath userId = createString("userId");

    public QProductOrder(String variable) {
        super(ProductOrder.class, forVariable(variable));
    }

    public QProductOrder(Path<? extends ProductOrder> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductOrder(PathMetadata metadata) {
        super(ProductOrder.class, metadata);
    }

}

