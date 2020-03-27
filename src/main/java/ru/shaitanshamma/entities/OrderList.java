package ru.shaitanshamma.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order_list_tbl")
public class OrderList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "quantity_fld")
    private Long quantity;

    @Column(name = "item_price_fld")
    private BigDecimal itemPrice;

    @Column(name = "total_price_fld")
    private BigDecimal totalPrice;

}
