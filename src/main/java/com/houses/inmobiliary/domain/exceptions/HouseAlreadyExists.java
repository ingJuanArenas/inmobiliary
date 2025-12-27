package com.houses.inmobiliary.domain.exceptions;

public class HouseAlreadyExists extends RuntimeException {
    public HouseAlreadyExists() {
        super("House already exists");
    }
}
