package com.houses.inmobiliary.domain.dto;

public record UpdateDTO(
    String address,
    Double price,
    Integer bedrooms,
    Integer bathrooms
) {
    
}
