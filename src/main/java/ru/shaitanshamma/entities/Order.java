package ru.shaitanshamma.entities;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order_tbl")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_client")
    @NotNull
    private Client client;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;


    //    @Column(name = "id_product")
//    @NotNull
//    private Long idProduct;
//
//    @Column(name = "order_date_fld")
//    @NotNull
//    private Long orderDate;
    @Column(name = "create_at_fld")
    @CreationTimestamp
    private LocalDateTime createAt;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
//
//    public Long getIdProduct() {
//        return idProduct;
//    }
//
//    public void setIdProduct(Long idProduct) {
//        this.idProduct = idProduct;
//    }
//
//    public Long getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(Long orderDate) {
//        this.orderDate = orderDate;
//    }


    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

}
