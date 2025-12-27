package com.houses.inmobiliary.domain.repository;

import java.util.List;

import com.houses.inmobiliary.domain.dto.HouseDTO;
import com.houses.inmobiliary.domain.dto.UpdateDTO;
import com.houses.inmobiliary.persistence.model.House;

public interface HouseRepository {

    List<HouseDTO> getAll();
    HouseDTO getById(Long id);
    List<HouseDTO> getByCity(String city);
    HouseDTO create(House house);
    HouseDTO update(Long id, UpdateDTO houseDTO);
    void delete(Long id);

}