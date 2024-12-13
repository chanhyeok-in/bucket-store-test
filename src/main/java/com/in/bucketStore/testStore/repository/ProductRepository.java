package com.in.bucketStore.testStore.repository;

import com.in.bucketStore.testStore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public interface ProductRepository extends JpaRepository<Product, String> {

}
