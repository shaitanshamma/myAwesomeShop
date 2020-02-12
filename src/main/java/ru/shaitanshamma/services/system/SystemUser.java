package ru.shaitanshamma.services.system;


import ru.shaitanshamma.entities.Client;

public class SystemUser {

    private Long id;

    private String name;

    private String lastName;

    private String login;

    private String password;

    private String email;

    private int phone;

    private int role;

    public SystemUser() {

    }

    public SystemUser(String name, String lastName, String login, String password, String email, int phone, int role) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public SystemUser(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.lastName = client.getLastName();
        this.login = client.getLogin();
        this.password = client.getPassword();
        this.email = client.getEmail();
        this.phone = client.getPhone();
        this.role = client.getRole();
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
