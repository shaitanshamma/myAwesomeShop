package ru.shaitanshamma.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.shaitanshamma.repositories.BrandRepository;
import ru.shaitanshamma.repositories.CategoryRepository;
import ru.shaitanshamma.services.ClientService;
import ru.shaitanshamma.services.ProductService;



// Test
@Controller
public class CartController {

//    private static final Logger logger = LoggerFactory.getLogger(AdminProductsController.class);
//
//    private final ProductService productService;
//
//    private final ClientService clientService;
//
//    @Autowired
//    public CartController (ProductService productService, ClientService clientService){
//        this.productService = productService;
//        this.clientService = clientService;
//    }
//
//    @GetMapping("/cart")
//    public String cartProductsPage(Model model) {
//        model.addAttribute("activePage", "Products");
//        model.addAttribute("cart", productService.findAll());
//        return "/cart";
//    }

}
