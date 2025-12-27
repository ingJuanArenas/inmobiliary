package com.houses.inmobiliary.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.houses.inmobiliary.domain.dto.HouseDTO;
import com.houses.inmobiliary.persistence.model.House;

@Mapper
public interface HouseMapper {
    @Mapping(target = "id", ignore = true)
    House toEntity(HouseDTO houseDTO);

    List<HouseDTO> tDtos(List<House> houses);
    HouseDTO toDto(House house);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(HouseDTO houseDTO, @MappingTarget House house);
}
