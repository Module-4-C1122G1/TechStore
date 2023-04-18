package com.techstore.controller.home;

import com.techstore.model.cart.Cart;
import com.techstore.model.product.Product;
import com.techstore.service.IProductService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
@SessionAttributes("cart")
public class HomeRestController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/add-cart/{id}")
    public ResponseEntity<Map<String, Integer>> addProductToCart(@PathVariable int id, @ModelAttribute Cart cart) {
        Product product = productService.findById(id);
        cart.addProduct(product);
        Map<String, Integer> map = new HashMap<>();
        map.put("amount", cart.selectItemInCart(product).getValue());
        map.put("price", cart.calculateTotalByProduct(product));
        map.put("amountMoney", cart.countTotalPayment());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/subtract-cart/{id}")
    public ResponseEntity<Map<String, Integer>> subtractProductToCart(@PathVariable int id, @ModelAttribute Cart cart) {
        Product product = productService.findById(id);
        cart.subtractProduct(product);
        Map<String, Integer> map = new HashMap<>();
        map.put("amount", cart.selectItemInCart(product).getValue());
        map.put("price", cart.calculateTotalByProduct(product));
        map.put("amountMoney", cart.countTotalPayment());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/delete-product-cart/{id}")
    public ResponseEntity<Map<String, Integer>> deleteProductInCart(@PathVariable int id, @ModelAttribute Cart cart) {
        Product product = productService.findById(id);
        cart.deleteProduct(product);
        Map<String, Integer> map = new HashMap<>();
        map.put("amountMoney", cart.countTotalPayment());
        map.put("amountItems", cart.countItemQuantity());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
