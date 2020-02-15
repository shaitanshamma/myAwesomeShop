package ru.shaitanshamma.entities.dot;

import org.springframework.web.multipart.MultipartFile;
import ru.shaitanshamma.entities.Category;
import ru.shaitanshamma.entities.Picture;
import ru.shaitanshamma.entities.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDot {

    private Long id;

    private String title;

    private String about;

    private Long category;

    private Long price;

    private Long quantity;

    private Long brand;

    private List<Picture> pictures;

    private MultipartFile[] newPictures;

    public List<Picture> getPictures() {
        return pictures;
    }

    public MultipartFile[] getNewPictures() {
        return newPictures;
    }

    public ProductDot(Product product) {
    this.id = product.getId();
    this.title = product.getTitle();
    this.about = product.getAbout();
    this.category = product.getCategory();
    this.price = product.getPrice();
    this.quantity = product.getQuantity();
    this.brand = product.getBrand();
    this.pictures = product.getPictures();
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

//    public String getCategoriesAsString() {
//        return getCategory().
////                .stream()
////                .map(Category::getTitle)
////                .collect(Collectors.joining(", "));
//    }

}
