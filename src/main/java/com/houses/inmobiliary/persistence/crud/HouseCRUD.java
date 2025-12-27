package com.houses.inmobiliary.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.houses.inmobiliary.persistence.model.House;

public interface HouseCRUD extends CrudRepository<House,Long> {

    List<House> findByCity(String city);
}