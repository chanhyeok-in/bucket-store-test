package com.in.bucketStore.testStore.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = -1785947434L;

    public static final QProduct product = new QProduct("product");

    public final StringPath category = createString("category");

    public final StringPath createdAt = createString("createdAt");

    public final BooleanPath deleted = createBoolean("deleted");

    public final StringPath description = createString("description");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final EnumPath<com.in.bucketStore.testStore.model.enums.ProductStatus> status = createEnum("status", com.in.bucketStore.testStore.model.enums.ProductStatus.class);

    public final StringPath updatedAt = createString("updatedAt");

    public QProduct(String variable) {
        super(Product.class, forVariable(variable));
    }

    public QProduct(Path<? extends Product> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProduct(PathMetadata metadata) {
        super(Product.class, metadata);
    }

}

