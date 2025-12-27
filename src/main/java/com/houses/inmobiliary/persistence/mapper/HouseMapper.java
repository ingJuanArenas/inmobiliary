package com.houses.inmobiliary.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.houses.inmobiliary.domain.dto.HouseDTO;
import com.houses.inmobiliary.domain.dto.UpdateDTO;
import com.houses.inmobiliary.persistence.model.House;

@Mapper(componentModel = "spring")
public interface HouseMapper {
    @Mapping(target = "id", ignore = true)
    House toEntity(HouseDTO houseDTO);

    
    HouseDTO toDto(House house);
    List<HouseDTO> tDtos(List<House> houses);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(UpdateDTO updateDTO, @MappingTarget House house);
}
