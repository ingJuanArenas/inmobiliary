package com.houses.inmobiliary.domain.exceptions;

public class HouseNotFoundException extends RuntimeException {
    
    public HouseNotFoundException() {
        super("House not found");
    }
}
