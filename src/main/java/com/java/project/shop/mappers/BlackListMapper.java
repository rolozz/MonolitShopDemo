package com.java.project.shop.mappers;

import com.java.project.shop.dto.BlackListDto;
import com.java.project.shop.entities.BlackList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BlackListMapper {

    @Mapping(target = "id", ignore = true)
    BlackList toEntity(BlackListDto blackListDto);

    BlackListDto toDto(BlackList blackList);

    @Mapping(target = "id", ignore = true)
    BlackList mergeToEntity(BlackListDto blackListDto, @MappingTarget BlackList blackList);

    List<BlackListDto> toDtoList(List<BlackList> blackLists);

}
