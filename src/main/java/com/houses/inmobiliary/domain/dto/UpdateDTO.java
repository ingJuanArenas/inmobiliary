package com.houses.inmobiliary.domain.dto;

public record UpdateDTO(
    String city,
    Double price,
    Integer bedrooms,
    Integer bathrooms
) {
    
}
