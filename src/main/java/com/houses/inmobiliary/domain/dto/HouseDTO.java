package com.houses.inmobiliary.domain.dto;

public record HouseDTO(
    String address,
    Double price,
    Integer bedrooms,
    Integer bathrooms
) {
} 