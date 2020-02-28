package ru.shaitanshamma.flow.order;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class AdressInfo implements Serializable {

    @NotBlank
    private String country;

    @NotBlank
    private String city;

    @NotBlank
    private Integer zipCode;

    @NotBlank
    private String region;

    @NotBlank
    private String street;

    @NotBlank
    private Integer appartaments;

    @NotBlank
    private Integer building;

    public AdressInfo() {
    }
}
