package com.techstore.controller.home;

import com.techstore.model.cart.Cart;
import com.techstore.model.product.Product;
import com.techstore.service.IProductService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("cart")
public class HomeController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping({"", "/product"})
    public ModelAndView showHomePage(@RequestParam(defaultValue = "1") int categories, @RequestParam(defaultValue = "0") int page, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("home/home");
        pageable = PageRequest.of(page, 12);
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("pageCurrent", page);
        modelAndView.addObject("productList", productService.findAllProductById(categories, pageable));
        return modelAndView;
    }

    @GetMapping("/product/manufacturer/{id}")
    public ModelAndView showProductListByManufacturer(@PathVariable int id, @RequestParam(defaultValue = "0") int page, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("home/home");
        pageable = PageRequest.of(page, 12);
        modelAndView.addObject("manufacturer", id);
        modelAndView.addObject("pageCurrent", page);
        modelAndView.addObject("productList", productService.findProductsByManufacturerId(id, pageable));
        return modelAndView;
    }

    @GetMapping("/product/detail/{id}")
    public ModelAndView showOrderProductPage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("home/detail");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    @GetMapping("/product/add-cart/{id}")
    public String addProductToCart(@PathVariable int id, @ModelAttribute Cart cart) {
        Product product = productService.findById(id);
        cart.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("cart/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView showFormLogin() {
        ModelAndView modelAndView = new ModelAndView("login/login");
        return modelAndView;
    }
}
