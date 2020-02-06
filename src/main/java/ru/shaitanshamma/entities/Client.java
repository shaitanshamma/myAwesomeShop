package ru.shaitanshamma.entities;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "client_tbl")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_fld")
    @NotNull
    private String name;

    @Column(name = "last_name_fld")
    @NotNull
    private String lastName;

    @Column(name = "login_fld")
    @NotNull
    private String login;

    @Column(name = "password_fld")
    @NotNull
    private String password;

    @Column(name = "email_fld")
    @NotNull
    private String email;

    @Column(name = "phone_fld")
    @NotNull
    private int phone;

    @Column(name = "role_fld")
    @NotNull
    private int role;

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
