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

@Entity
@Table(name = "houses")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    @NotBlank
    private String city;

    @Column(name = "price")
    @NotNull
    private Double price;

    @Column(name = "bedrooms")
    @Min(value = 1)
    @NotNull
    private Integer bedrooms;

    @Column(name = "bathrooms")
    @Min(value = 1)
    @NotNull
    private Integer bathrooms;

    public House() {}

    public House(String city, Double price, Integer bedrooms, Integer bathrooms) {
        this.city = city;
        this.price = price;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

	public Integer getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(Integer bathrooms) {
		this.bathrooms = bathrooms;
	}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}