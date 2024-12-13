package com.in.bucketStore.testStore.repositorySupport;

import com.in.bucketStore.testStore.entity.Product;
import com.in.bucketStore.testStore.entity.QProduct;
import com.in.bucketStore.testStore.model.enums.ProductSearchOption;
import com.in.bucketStore.testStore.model.enums.SortOption;
import com.in.bucketStore.testStore.model.request.ProductSearchRequest;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositorySupport extends QuerydslRepositorySupport {
    private static final QProduct product = QProduct.product;
    private static final int DEFAULT_LIMIT = 1;
    private final JPAQueryFactory queryFactory;

    public ProductRepositorySupport(JPAQueryFactory queryFactory) {
        super(Product.class);
        this.queryFactory = queryFactory;
    }

    public List<Product> findByOrderBy(ProductSearchRequest request) {
        OrderSpecifier sort = QProduct.product.createdAt.desc();
        long size = request.getLimit();
        if (ProductSearchOption.NAME.equals(request.getProductSearchOption())) {
            if (SortOption.ASC.equals(request.getSortOption())) {
                sort = QProduct.product.name.asc();
            } else {
                sort = QProduct.product.name.desc();
            }
        }
        if (ProductSearchOption.STATUS.equals(request.getProductSearchOption())) {
            if (SortOption.ASC.equals(request.getSortOption())) {
                sort = QProduct.product.status.asc();
            } else {
                sort = QProduct.product.status.desc();
            }
        }
        if (ProductSearchOption.CATEGORY.equals(request.getProductSearchOption())) {
            if (SortOption.ASC.equals(request.getSortOption())) {
                sort = QProduct.product.category.asc();
            } else {
                sort = QProduct.product.category.desc();
            }
        }
        if (ProductSearchOption.DESCRIPTION.equals(request.getProductSearchOption())) {
            if (SortOption.ASC.equals(request.getSortOption())) {
                sort = QProduct.product.description.asc();
            } else {
                sort = QProduct.product.description.desc();
            }
        }
        if (ProductSearchOption.CREATED_AT.equals(request.getProductSearchOption())) {
            if (SortOption.ASC.equals(request.getSortOption())) {
                sort = QProduct.product.createdAt.asc();
            } else {
                sort = QProduct.product.createdAt.desc();
            }
        }
        if (ProductSearchOption.UPDATED_AT.equals(request.getProductSearchOption())) {
            if (SortOption.ASC.equals(request.getSortOption())) {
                sort = QProduct.product.updatedAt.asc();
            } else {
                sort = QProduct.product.updatedAt.desc();
            }
        }

        if (request.getLimit() <= DEFAULT_LIMIT) {
            size = DEFAULT_LIMIT;
        }

        return queryFactory
                .selectFrom(product)
                .orderBy(sort)
                .limit(size)
                .fetch();
    }

}