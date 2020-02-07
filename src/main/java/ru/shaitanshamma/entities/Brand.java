package ru.shaitanshamma.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "brand_tbl")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title_fld")
    @NotNull
    private String title;

    public Brand() {
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

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
