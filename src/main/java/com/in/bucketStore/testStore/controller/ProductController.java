package com.in.bucketStore.testStore.controller;

import com.in.bucketStore.testStore.Service.ProductService;
import com.in.bucketStore.testStore.model.dto.ProductDto;
import com.in.bucketStore.testStore.model.request.ProductSearchRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    @Operation(summary = "Get Products Info", description = " 입력된 정렬기준(NAME, STATUS, CATEGORY, DESCRIPTION, CREATED_AT, UPDATED_AT)과 순서(ASC, DESC)로 상품 정보를 limit(>0) 개 조회")
    public List<ProductDto> getProducts(@ModelAttribute ProductSearchRequest request) {
        return productService.getProducts(request);
    }
}
