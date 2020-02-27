package ru.shaitanshamma.entities.dot;


import ru.shaitanshamma.entities.dot.validation.EmailNotRegistered;

import javax.validation.constraints.NotBlank;

public class SignupForm {

    @NotBlank
    @EmailNotRegistered
    private String email;

    public SignupForm() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
