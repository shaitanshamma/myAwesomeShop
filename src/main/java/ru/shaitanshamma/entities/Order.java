package ru.shaitanshamma.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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
    private List<OrderList> orderLists;

    @Column(name = "create_at_fld")
    @CreationTimestamp
    private LocalDateTime createAt;

    public Order(Client client) {
        this.client = client;
    }
}
