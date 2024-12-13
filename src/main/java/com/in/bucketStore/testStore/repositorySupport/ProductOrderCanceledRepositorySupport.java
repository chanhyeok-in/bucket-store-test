package com.in.bucketStore.testStore.repositorySupport;

import com.in.bucketStore.testStore.entity.ProductOrderCanceled;
import com.in.bucketStore.testStore.entity.QProductOrderCanceled;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductOrderCanceledRepositorySupport extends QuerydslRepositorySupport {
    private static final QProductOrderCanceled productOrderCanceled = QProductOrderCanceled.productOrderCanceled;
    private static final int DEFAULT_LIMIT = 1;
    private final JPAQueryFactory queryFactory;

    public ProductOrderCanceledRepositorySupport(JPAQueryFactory queryFactory) {
        super(ProductOrderCanceled.class);
        this.queryFactory = queryFactory;
    }

    public List<ProductOrderCanceled> findByProductOrderId(String productOrderId) {

        return queryFactory
                .selectFrom(productOrderCanceled)
                .where(productOrderCanceled.productOrderId.eq(productOrderId))
                .fetch();
    }

}