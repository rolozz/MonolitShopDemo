package com.java.project.shop.mappers;

import com.java.project.shop.dto.ProductDto;
import com.java.project.shop.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    Product toEntity(ProductDto productDto);

    ProductDto toDto(Product product);

    @Mapping(target = "id", ignore = true)
    Product mergeToEntity(ProductDto productDto, @MappingTarget Product product);

}
