package ru.shaitanshamma.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order_adress_tbl")
public class OrderAdress {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long id;

    @Column(name = "country_fld")
    @NotNull
    private String country;

    @Column(name = "city_fld")
    @NotNull
    private String city;

    @Column(name = "post_index_fld")
    @NotNull
    private int postIndex;

    @Column(name = "street_fld")
    @NotNull
    private String street;

    @Column(name = "region_fld")
    private String region;

    @Column(name = "appartament_fld")
    @NotNull
    private int appartament;

    @Column(name = "building_fld")
    @NotNull
    private int building;

//    @ManyToOne()
//    @JoinColumn(name ="id_client", insertable = false, updatable = false)
//    private Client client;


    @Override
    public String toString() {
        return "OrderAdress{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", postIndex=" + postIndex +
                ", street='" + street + '\'' +
                ", region='" + region + '\'' +
                ", appartament=" + appartament +
                ", building=" + building +
                '}';
    }
}
