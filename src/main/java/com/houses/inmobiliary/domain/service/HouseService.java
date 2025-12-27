package com.houses.inmobiliary.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.houses.inmobiliary.domain.dto.HouseDTO;
import com.houses.inmobiliary.domain.dto.UpdateDTO;
import com.houses.inmobiliary.domain.repository.HouseRepository;
import com.houses.inmobiliary.persistence.model.House;

@Service
public class HouseService {
    
    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public List<HouseDTO> getAllHouses() {
        return houseRepository.getAll();
    }

    public HouseDTO getHouseById(Long id) {
        return houseRepository.getById(id);
    }

    public List<HouseDTO> getHousesByCity(String city) {
        return houseRepository.getByCity(city);
    }

    public HouseDTO createHouse(House houseDTO) {
        return houseRepository.create(houseDTO);
    }

    public HouseDTO updateHouseById(Long id, UpdateDTO houseDTO) {
        return houseRepository.update(id, houseDTO);
    }

    public void deleteHouseById(Long id) {
        houseRepository.delete(id);
    }
}


