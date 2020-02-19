package ru.shaitanshamma.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pictures_tbl")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_fld", nullable = false)
    private String name;

    @Column(name = "content_fld", nullable = false)
    private String contentType;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name="picture_data_id")
    private PictureData pictureData;

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name = "products_pictures_tbl",
            joinColumns = @JoinColumn(name = "picture_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public Picture() {
    }

    public Picture(String name, String contentType, PictureData pictureData) {
        this.name = name;
        this.contentType = contentType;
        this.pictureData = pictureData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public PictureData getPictureData() {
        return pictureData;
    }

    public void setPictureData(PictureData pictureData) {
        this.pictureData = pictureData;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
