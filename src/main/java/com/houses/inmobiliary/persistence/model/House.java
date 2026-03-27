package com.houses.inmobiliary.persistence.model;

import org.hibernate.internal.build.AllowNonPortable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "houses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city", nullable = false)
    @NotBlank
    private String city;

    @Column(name = "price",nullable = false)
    @NotNull
    private Double price;

    @Column(name = "bedrooms", nullable = false)
    @Min(value = 1)
    @NotNull
    private Integer bedrooms;

    @Column(name = "bathrooms", nullable = false)
    @Min(value = 1)
    @NotNull
    private Integer bathrooms;

}