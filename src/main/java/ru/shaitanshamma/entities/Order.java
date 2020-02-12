package ru.shaitanshamma.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_tbl")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_client")
    @NotNull
    private Long idClient;

    @Column(name = "id_product")
    @NotNull
    private Long idProduct;

    @Column(name = "order_date_fld")
    @NotNull
    private Long orderDate;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Long orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", idClient=" + idClient +
                ", idProduct=" + idProduct +
                ", orderDate=" + orderDate +
                '}';
    }
}
