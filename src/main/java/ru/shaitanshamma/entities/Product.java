package ru.shaitanshamma.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "product_tbl")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title_fld")
    @NotNull
    private String title;

    @Column(name = "about_fld")
    @NotNull
    private String about;

//    @JoinColumn(name = "category_fld")
//    private Long category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "products_categories_tbl",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @ManyToOne(optional = false)
    private Brand brand;

    @Column(name = "price_fld")
    @NotNull
    private BigDecimal price;

    @Column(name = "quantity_fld")
    @NotNull
    private Long quantity;

//    @Column(name = "comment_fld")
//    private Long comment;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name = "products_pictures_tbl",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "picture_id"))
    private List<Picture> pictures;

     @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", about='" + about + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
