package ru.shaitanshamma.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.shaitanshamma.entities.dot.ProductDot;
import ru.shaitanshamma.repositories.BrandRepository;
import ru.shaitanshamma.repositories.CategoryRepository;
import ru.shaitanshamma.services.ProductService;
import ru.shaitanshamma.services.impl.ProductServiceImpl;

@Controller
public class AdminProductsController {

    private static final Logger logger = LoggerFactory.getLogger(AdminProductsController.class);

    private final ProductService productService;

    private final CategoryRepository categoryRepository;

    private final BrandRepository brandRepository;

    @Autowired
    public AdminProductsController(ProductService productService, CategoryRepository categoryRepository,
                                   BrandRepository brandRepository) {
        this.productService = productService;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
    }

    @GetMapping("/admin/products")
    public String adminProductsPage(Model model) {
        model.addAttribute("activePage", "Products");
        model.addAttribute("products", productService.findAll());
        return "admin/products";
    }

    @GetMapping("/admin/product/{id}/edit")
    public String adminEditProduct(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Products");
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("brands", brandRepository.findAll());
        return "admin/product_form";
    }

    @GetMapping("/admin/product/{id}/delete")
    public String adminDeleteProduct(Model model, @PathVariable("id") Long id) {
        model.addAttribute("activePage", "Products");
        productService.deleteById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/create")
    public String adminCreateProduct(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Products");
        model.addAttribute("product", new ProductDot());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("brands", brandRepository.findAll());
        return "admin/product_form";
    }

    @PostMapping("/admin/product")
    public String adminUpsertProduct(Model model, RedirectAttributes redirectAttributes, ProductDot productDot) {
        model.addAttribute("activePage", "Products");

        try {
            productService.save(productDot);
        } catch (Exception ex) {
            logger.error("Problem with creating or updating product", ex);
            redirectAttributes.addFlashAttribute("error", true);
            if (productDot.getId() == null) {
                return "redirect:/admin/product/create";
            }
            return "redirect:/admin/product/" + productDot.getId() + "/edit";
        }
        return "redirect:/admin/products";
    }
}
