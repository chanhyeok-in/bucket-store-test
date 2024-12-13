package com.in.bucketStore.testStore.repositorySupport;

import com.in.bucketStore.testStore.entity.ProductOrderDetail;
import com.in.bucketStore.testStore.entity.QProductOrderDetail;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductOrderDetailRepositorySupport extends QuerydslRepositorySupport {
    private static final QProductOrderDetail productOrderDetail = QProductOrderDetail.productOrderDetail;
    private static final int DEFAULT_LIMIT = 1;
    private final JPAQueryFactory queryFactory;

    public ProductOrderDetailRepositorySupport(JPAQueryFactory queryFactory) {
        super(ProductOrderDetail.class);
        this.queryFactory = queryFactory;
    }

    public List<ProductOrderDetail> findByProductOrderId(String productOrderId) {

        return queryFactory
                .selectFrom(productOrderDetail)
                .where(productOrderDetail.productOrderId.eq(productOrderId))
                .fetch();
    }

}