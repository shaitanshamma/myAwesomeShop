package ru.shaitanshamma.entities.dot;

import ru.shaitanshamma.entities.Product;

public class ProductDot {

    private Long id;

    private String title;

    private String about;

    private Long category;

    private Long price;

    private Long quantity;

    private Long brand;

    public ProductDot(Product product) {
    this.id = product.getId();
    this.title = product.getTitle();
    this.about = product.getAbout();
    this.category = product.getCategory();
    this.price = product.getPrice();
    this.quantity = product.getQuantity();
    this.brand = product.getBrand();
    }

    public ProductDot() {

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
}
