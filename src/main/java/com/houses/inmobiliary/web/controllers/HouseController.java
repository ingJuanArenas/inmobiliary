package com.houses.inmobiliary.web.controllers;

import java.util.List;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/houses")
public class HouseController {
    
    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }


    @GetMapping
    @Operation(summary = "Get all houses", description = "Retrieve a list of all houses available in the system.")
    public ResponseEntity<List<HouseDTO>> getAllHouses() {
        List<HouseDTO> houses = houseService.getAllHouses();
        return ResponseEntity.ok(houses);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get house by ID", description = "Retrieve a specific house by its unique ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "House found and returned successfully."),
        @ApiResponse(responseCode = "404", description = "House with the specified ID not found.")
    })
    public ResponseEntity<HouseDTO> getHouseById(@PathVariable Long id) {
        HouseDTO house = houseService.getHouseById(id);
        return ResponseEntity.ok(house);
    }


    @GetMapping("/city/{city}")
    @Operation(summary = "Get houses by city", description = "Retrieve a list of houses located in the specified city.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Houses found and returned successfully."),
        @ApiResponse(responseCode = "404", description = "No houses found in the specified city.")
    })
    public ResponseEntity<List<HouseDTO>> getHouseByCity(@PathVariable String city) {
        List<HouseDTO> houses = houseService.getHousesByCity(city);
        return ResponseEntity.ok(houses);
    }

    @PostMapping
    @Operation(summary = "Create a new house", description = "Create a new house in the system.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "House created successfully."),
        @ApiResponse(responseCode = "400", description = "Invalid house data provided.")
    })
    public ResponseEntity<HouseDTO> createHouse(@Valid @org.springframework.web.bind.annotation.RequestBody House house) {
        System.out.println("Received house data: " + house.getCity() + house.getPrice());
        return ResponseEntity.ok(houseService.createHouse(house));
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update an existing house", description = "Update the details of an existing house by its ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "House updated successfully."),
        @ApiResponse(responseCode = "400", description = "Invalid house data provided."),
        @ApiResponse(responseCode = "404", description = "House with the specified ID not found.")
    })
    public ResponseEntity<HouseDTO> updateHouseById(@PathVariable Long id,  @Valid @org.springframework.web.bind.annotation.RequestBody UpdateDTO houseDTO) {
        HouseDTO updatedHouse = houseService.updateHouseById(id, houseDTO);
        return ResponseEntity.ok(updatedHouse);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a house", description = "Delete an existing house by its ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "House deleted successfully."),
        @ApiResponse(responseCode = "404", description = "House with the specified ID not found.")
    })
    public ResponseEntity<Void> deleteHouseById(@PathVariable Long id) {
        houseService.deleteHouseById(id);
        return ResponseEntity.noContent().build();
    }

}
