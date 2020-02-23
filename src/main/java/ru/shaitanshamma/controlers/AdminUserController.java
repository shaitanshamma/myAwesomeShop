package ru.shaitanshamma.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.shaitanshamma.entities.Client;
import ru.shaitanshamma.repositories.RoleRepository;
import ru.shaitanshamma.services.ClientService;
import ru.shaitanshamma.services.system.SystemUser;

import javax.validation.Valid;

@Controller
public class AdminUserController {

    private final RoleRepository roleRepository;

    private final ClientService clientService;

    @Autowired
    public AdminUserController(RoleRepository roleRepository,
                               ClientService clientService) {
        this.roleRepository = roleRepository;
        this.clientService = clientService;
    }

    @GetMapping("/admin")
    public String adminIndexPage(Model model) {
        model.addAttribute("activePage", "None");
        return "admin/index";
    }

    @GetMapping("/admin/users")
    public String adminUsersPage(Model model) {
        model.addAttribute("activePage", "Users");
        model.addAttribute("users", clientService.findAll());
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/users";
    }

    @GetMapping("/admin/user/{id}/edit")
    public String adminEditUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", clientService.findById(id));
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/user_form";
    }

    @GetMapping("/admin/user/create")
    public String adminCreateUser(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", new Client());
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/user_form";
    }

    @PostMapping("/admin/user")
    public String adminUpsertUser(@Valid SystemUser user, Model model, BindingResult bindingResult) {
        model.addAttribute("activePage", "Users");

        if (bindingResult.hasErrors()) {
            return "admin/user_form";
        }

        clientService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/user/{id}/delete")
    public String adminDeleteUser(Model model, @PathVariable("id") Long id) {
        clientService.delete(id);
        return "admin/users";
    }

}
