package testEureka;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import testEureka.dot.Category;

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String indexPage(){
        return "index";
    }

//    @RequestMapping(value = "/category/create")
//    public String createCategory(){
//        return "categories_form";
//    }

    @GetMapping("/category/create")
    public String adminCategoriesCreate(Model model) {
        model.addAttribute("activePage", "Categories");
//        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("category", new Category());
        return "categories_form";
    }

}
