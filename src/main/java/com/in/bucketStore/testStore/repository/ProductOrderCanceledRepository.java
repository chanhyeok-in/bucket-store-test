package com.in.bucketStore.testStore.repository;

import com.in.bucketStore.testStore.entity.ProductOrderCanceled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public interface ProductOrderCanceledRepository extends JpaRepository<ProductOrderCanceled, String> {

}
