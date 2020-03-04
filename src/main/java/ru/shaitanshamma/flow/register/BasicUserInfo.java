package ru.shaitanshamma.flow.register;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class BasicUserInfo implements Serializable {

    @NotBlank
    private String email;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String login;

    @NotBlank
    private String confirmPassword;

    public BasicUserInfo() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
