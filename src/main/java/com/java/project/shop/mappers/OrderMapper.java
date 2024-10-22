package com.java.project.shop.mappers;

import com.java.project.shop.dto.OrderDto;
import com.java.project.shop.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "id", ignore = true)
    Order toEntity(OrderDto orderDto);

    OrderDto toDto(Order order);

    @Mapping(target = "id", ignore = true)
    Order mergeToEntity(OrderDto orderDto, @MappingTarget Order order);


}
