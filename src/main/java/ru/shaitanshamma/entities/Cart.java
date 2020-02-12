package ru.shaitanshamma.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cart_tbl")
public class Cart {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_client_fld")
    private Long idClient;

    @Column(name = "id_product_fld")
    private Long idProduct;

    @Column(name = "date_fld")
    private Date date;

    public Cart() {
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "idClient=" + idClient +
                ", idProduct=" + idProduct +
                ", date=" + date +
                '}';
    }
}
