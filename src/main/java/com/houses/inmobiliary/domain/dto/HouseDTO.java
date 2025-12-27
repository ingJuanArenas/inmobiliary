package com.houses.inmobiliary.domain.dto;

public record HouseDTO(
    String city,
    Double price,
    Integer bedrooms,
    Integer bathrooms
) {
} 