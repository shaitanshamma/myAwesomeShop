package ru.shaitanshamma.services.system;

import ru.shaitanshamma.entities.dot.ProductDot;

import java.util.Objects;

public class ProductInfo {

    private ProductDot product;

    private String size;

    private String color;

    public ProductInfo() {
    }

    public ProductInfo(ProductDot product, String size, String color) {
        this.product = product;
        this.size = size;
        this.color = color;
    }

    public ProductDot getProduct() {
        return product;
    }

    public void setProduct(ProductDot product) {
        this.product = product;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfo that = (ProductInfo) o;
        return product.equals(that.product) &&
                Objects.equals(size, that.size) &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, size, color);
    }
}
