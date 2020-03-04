package ru.shaitanshamma.flow.order;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class BasicOrderInfo implements Serializable {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

   // @NotBlank
    private Integer phone;

    public BasicOrderInfo() {
    }
}
