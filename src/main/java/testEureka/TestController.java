package testEureka;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import testEureka.dot.Category;
import testEureka.dot.ProductDot;

import java.util.List;

@Controller
public class TestController {
    private static final String REST_URL = "http://localhost:8189/";

    @GetMapping("/categories")
    public String categoriesPage(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        List<Category> categories = restTemplate.getForObject(REST_URL + "getAllCategories" , List.class);
        model.addAttribute("categories", categories);
        System.out.println(categories);
        return "eureka/categories";
    }

    @GetMapping("/product")
    public String productsPage(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        List<ProductDot> product = restTemplate.getForObject(REST_URL + "getAllProduct" , List.class);
        System.out.println(product);
        model.addAttribute("product", product);
        return "eureka/products";
    }
    @PostMapping("/category/create_new")
    public String insertCategory(Category category, Model model, BindingResult bindingResult) {
//        model.addAttribute("activePage", "Category");
        System.out.println(category);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Category> categoryResponseEntity = restTemplate.postForEntity(REST_URL + "createCategory"
        ,category,Category.class, new Object());
        System.out.println(categoryResponseEntity.getStatusCode());
        return "redirect:/eureka/categories";
    }
}
