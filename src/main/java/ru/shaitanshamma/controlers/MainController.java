package ru.shaitanshamma.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.shaitanshamma.entities.dot.ProductDot;
import ru.shaitanshamma.repositories.CartItemRepr;
import ru.shaitanshamma.repositories.ProductRepository;
import ru.shaitanshamma.repositories.ProductRepr;
import ru.shaitanshamma.services.CartService;
import ru.shaitanshamma.services.ProductService;
import ru.shaitanshamma.services.system.ProductInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private final ProductService productService;

    private final CartService cartService;

    @Autowired
    public MainController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("cartItems", cartService.findAllItems());
        return "index";
    }

    @GetMapping("/cart")
    public String cartPage(Model model) {
        model.addAttribute("product", cartService.findAllItems());
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkoutPage() {
        return "flows/checkout/order-basic";
    }

    @GetMapping("/product/{id}")
    public String productPage(Model model, @PathVariable("id") Long id) {
        logger.info("Product {} page", id);
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @GetMapping("/store")
    public String storePage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "store";
    }

    @PostMapping("/cart/update")
    public String updateCart(CartItemRepr cartItemRepr, HttpServletRequest httpServletRequest) {
        logger.info("Update customer cart");
        ProductDot product = productService.findById(cartItemRepr.getProductId());

        if (product != null) {
            cartService.addItemQty(new ProductInfo(product, "", ""), cartItemRepr.getQty());
        }
        return "redirect:" + cartItemRepr.getPageUrl();
    }
}
