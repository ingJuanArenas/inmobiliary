package com.houses.inmobiliary.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateDTO(
 @NotBlank
    String city,
    @NotNull
    Double price,
    @Min(value = 1)
    @NotNull
    Integer bedrooms,
    @Min(value = 1)
    @NotNull
    Integer bathrooms
) {
    
}
