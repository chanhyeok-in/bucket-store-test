package com.in.bucketStore.testStore.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductDetail is a Querydsl query type for ProductDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductDetail extends EntityPathBase<ProductDetail> {

    private static final long serialVersionUID = 1853204167L;

    public static final QProductDetail productDetail = new QProductDetail("productDetail");

    public final StringPath color = createString("color");

    public final BooleanPath deleted = createBoolean("deleted");

    public final StringPath id = createString("id");

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final StringPath productId = createString("productId");

    public final StringPath size = createString("size");

    public final EnumPath<com.in.bucketStore.testStore.model.enums.ProductDetailStatus> status = createEnum("status", com.in.bucketStore.testStore.model.enums.ProductDetailStatus.class);

    public final NumberPath<Long> stockQuantity = createNumber("stockQuantity", Long.class);

    public QProductDetail(String variable) {
        super(ProductDetail.class, forVariable(variable));
    }

    public QProductDetail(Path<? extends ProductDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductDetail(PathMetadata metadata) {
        super(ProductDetail.class, metadata);
    }

}

