package ru.shaitanshamma.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.shaitanshamma.entities.Brand;
import ru.shaitanshamma.entities.Category;
import ru.shaitanshamma.repositories.BrandRepository;

@Controller
public class AdminBrandController {

    private final BrandRepository brandRepository;

    @Autowired
    public AdminBrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping("/admin/brands")
    public String adminCategoriesPage(Model model) {
        model.addAttribute("activePage", "Brands");
        model.addAttribute("brands", brandRepository.findAll());
        return "admin/brands";
    }

    @GetMapping("/admin/brands/{id}/edit")
    public String adminEditCategory(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Brands");
        return "admin/brands";
    }

    @GetMapping("/admin/brands/{id}/delete")
    public String adminDeleteCategory(Model model, @PathVariable("id") Long id) {
        model.addAttribute("activePage", "Brands");
        return "admin/brands";
    }

    @GetMapping("/admin/brands/create")
    public String adminCategoriesCreate(Model model) {
        model.addAttribute("activePage", "Categories");
        model.addAttribute("brands", brandRepository.findAll());
        model.addAttribute("brands", new Brand());
        return "admin/brands_form";
    }

    @PostMapping("/admin/brands")
    public String adminUpsertCategory(Brand brand, Model model, BindingResult bindingResult) {
        model.addAttribute("activePage", "Brands");

        if (bindingResult.hasErrors()) {
            return "admin/brands_form";
        }
        brandRepository.save(brand);
        return "redirect:/admin/brands";
    }

    @GetMapping("/admin/message")
    public String adminMessagePage(Model model) {
        model.addAttribute("activePage", "Message");
        return "admin/message";
    }
}
