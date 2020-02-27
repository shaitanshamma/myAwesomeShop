package ru.shaitanshamma.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
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
