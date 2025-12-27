package com.houses.inmobiliary.web.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.houses.inmobiliary.domain.dto.HouseDTO;
import com.houses.inmobiliary.domain.dto.UpdateDTO;
import com.houses.inmobiliary.domain.service.HouseService;
import com.houses.inmobiliary.persistence.model.House;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/houses")
public class HouseController {
    
    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }


    @GetMapping
    public ResponseEntity<List<HouseDTO>> getAllHouses() {
        List<HouseDTO> houses = houseService.getAllHouses();
        return ResponseEntity.ok(houses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HouseDTO> getHouseById(@PathVariable Long id) {
        HouseDTO house = houseService.getHouseById(id);
        return ResponseEntity.ok(house);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<HouseDTO>> getHouseByCity(@PathVariable String city) {
        List<HouseDTO> houses = houseService.getHousesByCity(city);
        return ResponseEntity.ok(houses);
    }

    @PostMapping
    public ResponseEntity<HouseDTO> createHouse(@RequestBody House houseDTO) {
        HouseDTO createdHouse = houseService.createHouse(houseDTO);
        return ResponseEntity.status(Response.SC_CREATED).body(createdHouse);
    }


    @PutMapping("/{id}")
    public ResponseEntity<HouseDTO> updateHouseById(@PathVariable Long id, @RequestBody UpdateDTO houseDTO) {
        HouseDTO updatedHouse = houseService.updateHouseById(id, houseDTO);
        return ResponseEntity.ok(updatedHouse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHouseById(@PathVariable Long id) {
        houseService.deleteHouseById(id);
        return ResponseEntity.noContent().build();
    }


}
