package com.houses.inmobiliary.persistence.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houses.inmobiliary.persistence.model.House;

public interface HouseCRUD extends JpaRepository<House,Long> {

    List<House> findByCity(String city);
}