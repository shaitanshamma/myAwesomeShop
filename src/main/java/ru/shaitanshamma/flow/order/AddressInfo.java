package ru.shaitanshamma.flow.order;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


public class AddressInfo implements Serializable {

    @NotBlank
    private String country;

    @NotBlank
    private String city;

    private Integer zipCode;

    @NotBlank
    private String region;

    @NotBlank
    private String street;

    private Integer appartaments;

    private Integer building;

    public AddressInfo() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getAppartaments() {
        return appartaments;
    }

    public void setAppartaments(Integer appartaments) {
        this.appartaments = appartaments;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }
}
