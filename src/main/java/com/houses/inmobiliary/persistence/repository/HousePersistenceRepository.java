package com.houses.inmobiliary.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.houses.inmobiliary.domain.dto.HouseDTO;
import com.houses.inmobiliary.domain.dto.UpdateDTO;
import com.houses.inmobiliary.domain.exceptions.HouseNotFoundException;
import com.houses.inmobiliary.domain.repository.HouseRepository;
import com.houses.inmobiliary.persistence.crud.HouseCRUD;
import com.houses.inmobiliary.persistence.mapper.HouseMapper;
import com.houses.inmobiliary.persistence.model.House;


@Repository
public class HousePersistenceRepository implements HouseRepository {

    private final HouseCRUD houseCRUD;
    private final HouseMapper houseMapper;

    public HousePersistenceRepository(HouseCRUD houseCRUD, HouseMapper houseMapper) {
        this.houseCRUD = houseCRUD;
        this.houseMapper = houseMapper;
    }

    @Override
    public List<HouseDTO> getAll() {
        List<House> houses= (List<House>)  houseCRUD.findAll();
        return houseMapper.tDtos(houses);
    }

    @Override
    public HouseDTO getById(Long id) {
        House house = houseCRUD.findById(id).orElseThrow( () -> new HouseNotFoundException());
        return houseMapper.toDto(house);
    }

    @Override
    public List<HouseDTO> getByCity(String city) {
        List<House> houses = houseCRUD.findByCity(city);
        if (houses.isEmpty()){
            throw new HouseNotFoundException();
        }
        return houseMapper.tDtos(houses);
    }

    @Override
    public HouseDTO create(House house) {
        House savedHouse = houseCRUD.save(house);
        return houseMapper.toDto(savedHouse);
    }

    @Override
    public HouseDTO update(Long id, UpdateDTO houseDTO) {
        House existingHouse = houseCRUD.findById(id).orElseThrow( () -> new HouseNotFoundException());
        houseMapper.updateEntityFromDto(houseDTO, existingHouse);
        House updatedHouse = houseCRUD.save(existingHouse);
        return houseMapper.toDto(updatedHouse);
    }

    @Override
    public void delete(Long id) {
        if (!houseCRUD.existsById(id)) {
            throw new HouseNotFoundException();
        }
        houseCRUD.deleteById(id);
    }
    
}
