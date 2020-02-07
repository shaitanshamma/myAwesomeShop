package ru.shaitanshamma.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
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

    @Column(name = "category_fld")
    @NotNull
    private Long category;

    @Column(name = "price_fld")
    @NotNull
    private Long price;

    @Column(name = "quantity_fld")
    @NotNull
    private Long quantity;

    @Column(name = "brand_fld")
    @NotNull
    private Long brand;


    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getBrand() {
        return brand;
    }

    public void setBrand(Long brand) {
        this.brand = brand;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", about='" + about + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
