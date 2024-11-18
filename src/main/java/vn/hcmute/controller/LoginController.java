package vn.hcmute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.hcmute.entity.Product;
import vn.hcmute.service.impl.ProductService;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private ProductService productService;

    @PostMapping("/login_succes_handler")
    public String loginSuccesHandler(){
        System.out.println("Login user login succes......");
        return "index";
    }

    @PostMapping("/login_failure_handler")
    public String loginFailureHandler(){
        System.out.println("Login failure handler......");
        return "login";
    }

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewProduct(Model model, @ModelAttribute("product") Product product){
        model.addAttribute("product", product);
        return "new_product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProduct(@PathVariable("id") Long id){
        ModelAndView mav = new ModelAndView("edit_product");

        Product product = productService.get(id);
        mav.addObject("product", product);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.delete(id);
        return "redirect:/";
    }

}
