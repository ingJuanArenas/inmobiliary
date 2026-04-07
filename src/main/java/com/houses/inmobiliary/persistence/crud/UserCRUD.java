package com.houses.inmobiliary.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houses.inmobiliary.persistence.model.UserEntity;

public interface UserCRUD extends JpaRepository<UserEntity,String>{
    
}
