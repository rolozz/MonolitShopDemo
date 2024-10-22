package com.java.project.shop.mappers;

import com.java.project.shop.dto.DealDto;
import com.java.project.shop.entities.Deal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DealMapper {

    @Mapping(target = "id", ignore = true)
    Deal toEntity(DealDto dealDto);

    DealDto toDto(Deal deal);

    @Mapping(target = "id", ignore = true)
    Deal mergeToEntity(DealDto dealDto, @MappingTarget Deal deal);
}
