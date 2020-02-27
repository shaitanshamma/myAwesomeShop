package ru.shaitanshamma.entities.dot;

import org.springframework.web.multipart.MultipartFile;
import ru.shaitanshamma.entities.Brand;
import ru.shaitanshamma.entities.Category;
import ru.shaitanshamma.entities.Picture;
import ru.shaitanshamma.entities.Product;
import ru.shaitanshamma.repositories.PictureRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductDot {

    private Long id;

    private String title;

    private String about;

    private Set<Category> categories;

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    private BigDecimal price;

    private Long quantity;

    private Brand brand;

//    private Long comment;

    private List<PictureDot> pictures;

    private MultipartFile[] newPictures;


    public MultipartFile[] getNewPictures() {
        return newPictures;
    }

    public ProductDot(Product product) {
    this.id = product.getId();
    this.title = product.getTitle();
    this.about = product.getAbout();
    this.categories = product.getCategories();
    this.price = product.getPrice();
    this.quantity = product.getQuantity();
    this.brand = product.getBrand();
    this.pictures = product.getPictures().stream()
                .map(PictureDot::new)
                .collect(Collectors.toList());
//    this.comment = product.getComment();
    }

    public ProductDot() {

    }
//
//    public Long getComment() {
//        return comment;
//    }
//
//    public void setComment(Long comment) {
//        this.comment = comment;
//    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<PictureDot> getPictures() {
        return pictures;
    }

    public void setPictures(List<PictureDot> pictures) {
        this.pictures = pictures;
    }

    public void setNewPictures(MultipartFile[] newPictures) {
        this.newPictures = newPictures;
    }

    public String getCategoriesAsString() {
        return getCategories()
                .stream()
                .map(Category::getTitle)
                .collect(Collectors.joining(", "));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDot that = (ProductDot) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
