package com.java.project.shop.services.impl;

import com.java.project.shop.dto.ProductDto;
import com.java.project.shop.mappers.ProductMapper;
import com.java.project.shop.repositories.ProductRepository;
import com.java.project.shop.services.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    ProductMapper productMapper;

    @Override
    @Transactional
    public ProductDto save(ProductDto productDto) {
        productRepository.save(productMapper.toEntity(productDto));
        return productDto;
    }

}
