package com.houses.inmobiliary.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.houses.inmobiliary.domain.dto.HouseDTO;
import com.houses.inmobiliary.domain.dto.UpdateDTO;
import com.houses.inmobiliary.domain.exceptions.NotFoundException;
import com.houses.inmobiliary.domain.repository.HouseRepository;
import com.houses.inmobiliary.persistence.model.House;

@Service
public class HouseService {
    
    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public List<HouseDTO> getAllHouses() {
        var houses = houseRepository.getAll();
        if (houses.isEmpty()) throw new NotFoundException("Content not found");
        return houses ;
    }

    public HouseDTO getHouseById(Long id) {
        return houseRepository.getById(id);
    }

    public List<HouseDTO> getHousesByCity(String city) {
        var houses = houseRepository.getByCity(city);
        if (houses.isEmpty()){
            throw new NotFoundException("No content found for city: " + city);
        }
        return houses;
    }

    public HouseDTO createHouse(HouseDTO houseDTO) {
        return houseRepository.create(houseDTO);
    }

    public HouseDTO updateHouseById(Long id, UpdateDTO houseDTO) {
        return houseRepository.update(id, houseDTO);
    }

    public void deleteHouseById(Long id) {
        houseRepository.delete(id);
    }
}


