package ru.shaitanshamma.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_adress_tbl")
public class OrderAdress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long id;

    @Column(name = "country_fld")
    @NotNull
    private String country;

    @Column(name = "city_fld")
    @NotNull
    private String city;

    @Column(name = "post_index_fld")
    @NotNull
    private int postIndex;

    @Column(name = "street_fld")
    @NotNull
    private String street;

    @Column(name = "region_fld")
    private String region;

    @Column(name = "appartament_fld")
    @NotNull
    private int appartament;

    @Column(name = "building_fld")
    @NotNull
    private int building;

    public OrderAdress() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(int postIndex) {
        this.postIndex = postIndex;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getAppartament() {
        return appartament;
    }

    public void setAppartament(int appartament) {
        this.appartament = appartament;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "OrderAdress{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", postIndex=" + postIndex +
                ", street='" + street + '\'' +
                ", region='" + region + '\'' +
                ", appartament=" + appartament +
                ", building=" + building +
                '}';
    }
}
