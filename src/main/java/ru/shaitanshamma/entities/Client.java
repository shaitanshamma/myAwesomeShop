package ru.shaitanshamma.entities;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
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
