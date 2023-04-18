package com.techstore.controller.order;

import com.techstore.model.cart.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@SessionAttributes("cart")
public class OrderController {
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }
//    @GetMapping("/shopping-cart")
//    public ModelAndView saveProductsInCart(Principal principal, @SessionAttribute("cart") Cart cart) {
//        System.out.println(principal.getName());
//        return new ModelAndView();
//    }
}
