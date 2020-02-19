package ru.shaitanshamma.entities;


import javax.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime date;

    @Column(name = "product_price_fld")
    private Double itemPrice;

    @Column(name = "total_price_fld")
    private Double totalPrice;

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", idClient=" + idClient +
                ", idProduct=" + idProduct +
                ", date=" + date +
                '}';
    }
}
