package com.in.bucketStore.testStore.Service;

import com.in.bucketStore.testStore.entity.Product;
import com.in.bucketStore.testStore.model.dto.ProductDto;
import com.in.bucketStore.testStore.model.request.ProductSearchRequest;
import com.in.bucketStore.testStore.repository.ProductRepository;
import com.in.bucketStore.testStore.repositorySupport.ProductRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductRepositorySupport productRepositorySupport;

    public List<ProductDto> getProducts(ProductSearchRequest request) {
        List<Product> productList = productRepositorySupport.findByOrderBy(request);
        return productList.stream().map(Product::toDTO).toList();
    }
}
