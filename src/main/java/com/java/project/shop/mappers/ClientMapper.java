package com.java.project.shop.mappers;

import com.java.project.shop.dto.ClientDto;
import com.java.project.shop.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    Client toEntity(ClientDto clientDto);

    ClientDto toDto(Client client);

    @Mapping(target = "id", ignore = true)
    Client mergeToEntity(ClientDto clientDto, @MappingTarget Client client);

}
