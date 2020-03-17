package testEureka.dot;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;


public class ProductDot implements Serializable {

    private Long id;

    private String title;

    private String about;

    private Set<Category> categories;

    public Set<Category> getCategories() {
        return categories;
    }

    private BigDecimal price;

    private Long quantity;

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

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
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

    public ProductDot(Long id, String title, String about, Set<Category> categories, BigDecimal price, Long quantity) {
        this.id = id;
        this.title = title;
        this.about = about;
        this.categories = categories;
        this.price = price;
        this.quantity = quantity;
    }
}
