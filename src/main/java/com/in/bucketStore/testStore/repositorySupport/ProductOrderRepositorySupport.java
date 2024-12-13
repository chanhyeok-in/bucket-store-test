package com.in.bucketStore.testStore.repositorySupport;

import com.in.bucketStore.testStore.entity.ProductOrder;
import com.in.bucketStore.testStore.entity.QProductOrder;
import com.in.bucketStore.testStore.model.enums.ProductOrderSearchOption;
import com.in.bucketStore.testStore.model.enums.SortOption;
import com.in.bucketStore.testStore.model.request.ProductOrderSearchRequest;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductOrderRepositorySupport extends QuerydslRepositorySupport {
    private static final QProductOrder productOrder = QProductOrder.productOrder;
    private static final int DEFAULT_LIMIT = 1;
    private final JPAQueryFactory queryFactory;

    public ProductOrderRepositorySupport(JPAQueryFactory queryFactory) {
        super(ProductOrder.class);
        this.queryFactory = queryFactory;
    }

    public List<ProductOrder> findByOrderBy(ProductOrderSearchRequest request) {
        OrderSpecifier sort = QProductOrder.productOrder.createdAt.desc();
        long size = request.getLimit();
        if (ProductOrderSearchOption.STATUS.equals(request.getProductOrderSearchOption())) {
            if (SortOption.ASC.equals(request.getSortOption())) {
                sort = QProductOrder.productOrder.status.asc();
            } else {
                sort = QProductOrder.productOrder.status.desc();
            }
        }
        if (ProductOrderSearchOption.UID.equals(request.getProductOrderSearchOption())) {
            if (SortOption.ASC.equals(request.getSortOption())) {
                sort = QProductOrder.productOrder.userId.asc();
            } else {
                sort = QProductOrder.productOrder.userId.desc();
            }
        }
        if (ProductOrderSearchOption.CREATED_AT.equals(request.getProductOrderSearchOption())) {
            if (SortOption.ASC.equals(request.getSortOption())) {
                sort = QProductOrder.productOrder.createdAt.asc();
            } else {
                sort = QProductOrder.productOrder.createdAt.desc();
            }
        }
        if (ProductOrderSearchOption.UPDATED_AT.equals(request.getProductOrderSearchOption())) {
            if (SortOption.ASC.equals(request.getSortOption())) {
                sort = QProductOrder.productOrder.updatedAt.asc();
            } else {
                sort = QProductOrder.productOrder.updatedAt.desc();
            }
        }

        if (request.getLimit() <= DEFAULT_LIMIT) {
            size = DEFAULT_LIMIT;
        }

        return queryFactory
                .selectFrom(productOrder)
                .orderBy(sort)
                .limit(size)
                .fetch();
    }

}