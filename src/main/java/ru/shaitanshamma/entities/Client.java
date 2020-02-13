package ru.shaitanshamma.entities;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_tbl",
            joinColumns = @JoinColumn(name = "id_client"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles;

    public Client() {
        this.roles = new HashSet<>();
    }

    public Client(String name, String lastName, String login, String password, String email, int phone) {
        this(name,lastName,login,password,email,phone,new HashSet<>());
    }

    public Client(String name, String lastName, String login, String password, String email, int phone, Set<Role> roles) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
