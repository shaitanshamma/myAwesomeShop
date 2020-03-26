package ru.shaitanshamma.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shaitanshamma.entities.Category;
import ru.shaitanshamma.entities.dot.CategoryRepr;
import ru.shaitanshamma.entities.dot.ProductDot;
import ru.shaitanshamma.repositories.BrandRepository;
import ru.shaitanshamma.repositories.CategoryRepository;
import ru.shaitanshamma.services.ProductService;

import java.util.List;

@RestController
public class EurekaController {

     private final ProductService productService;

     private final CategoryRepository categoryRepository;

     private final BrandRepository brandRepository;

     @Autowired
     public EurekaController(ProductService productService, CategoryRepository categoryRepository,
                                    BrandRepository brandRepository) {
          this.productService = productService;
          this.categoryRepository = categoryRepository;
          this.brandRepository = brandRepository;
     }
     @GetMapping("/getAllCategories")
     public List<CategoryRepr> getAllCategories(){
          return categoryRepository.getAllCategoryRepr();
     }

     @GetMapping("/getAllProduct")
     public List<ProductDot> getAllProduct(){
          return productService.findAll();
     }

     @GetMapping("/createCategory")
     public void createCategory(Category category, Model model, BindingResult bindingResult) {
          model.addAttribute("activePage", "Category");
          categoryRepository.save(category);
     }
}
