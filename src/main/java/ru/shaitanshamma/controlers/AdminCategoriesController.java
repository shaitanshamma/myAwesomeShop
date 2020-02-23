package ru.shaitanshamma.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.shaitanshamma.entities.Category;
import ru.shaitanshamma.repositories.CategoryRepository;
import ru.shaitanshamma.repositories.RoleRepository;
import ru.shaitanshamma.services.system.SystemUser;

import javax.validation.Valid;

@Controller
public class AdminCategoriesController {

    private final CategoryRepository categoryRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public AdminCategoriesController(CategoryRepository categoryRepository, RoleRepository roleRepository) {
        this.categoryRepository = categoryRepository;
        this.roleRepository =roleRepository;
    }

    @GetMapping("/admin/categories")
    public String adminCategoriesPage(Model model) {
        model.addAttribute("activePage", "Categories");
        model.addAttribute("categories", categoryRepository.getAllCategoryRepr());
        return "admin/categories";
    }

    @GetMapping("/admin/roles")
    public String adminRolesPage(Model model) {
        model.addAttribute("activePage", "Roles");
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/roles";
    }

    @GetMapping("/admin/category/{id}/edit")
    public String adminEditCategory(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Categories");
        return "admin/categories";
    }

    @GetMapping("/admin/category/{id}/delete")
    public String adminDeleteCategory(Model model, @PathVariable("id") Long id) {
        model.addAttribute("activePage", "Categories");
        return "admin/categories";
    }

    @GetMapping("/admin/category/create")
    public String adminCategoriesCreate(Model model) {
        model.addAttribute("activePage", "Categories");
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("categories", new Category());
        return "admin/categories_form";
    }

    @PostMapping("/admin/categories")
    public String adminUpsertCategory(Category category, Model model, BindingResult bindingResult) {
        model.addAttribute("activePage", "Category");

        if (bindingResult.hasErrors()) {
            return "admin/categories_form";
        }
        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }
}
