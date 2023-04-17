package com.techstore.controller.home;

import com.techstore.model.cart.Cart;
import com.techstore.model.customer.Customer;
import com.techstore.model.order.Order;
import com.techstore.model.order.OrderProduct;
import com.techstore.model.product.Product;
import com.techstore.service.IAccountService.IAccountService;
import com.techstore.service.ICustomerService.ICustomerService;
import com.techstore.service.IOrderProductService.IOrderProductService;
import com.techstore.service.IOrderService.IOrderService;
import com.techstore.service.IProductService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.*;

@Controller
@SessionAttributes("cart")
public class HomeController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IOrderProductService orderProductService;

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

    Order order;
    String accountCurrent;
    int amountProduct;

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(Principal principal, @SessionAttribute("cart") Cart cart) {

//        Khi chưa đăng nhập tài khoản
        if (accountCurrent == null && principal == null) {
            ModelAndView modelAndView = new ModelAndView("cart/cart");
            modelAndView.addObject("cart", cart);
            return modelAndView;
        }

//        Khi mới restart chương trình
        if (((accountCurrent == null && principal != null)
                || (accountCurrent != null && !principal.getName().equals(accountCurrent))) && cart.countTotalProductQuantity() > 0) {
            accountCurrent = principal.getName();
            order = new Order();
            Customer customer = customerService.findByAccount(accountService.findAccountByName(principal.getName()));
            amountProduct = cart.countTotalProductQuantity();
            order.setDateOrder(new Date());
            order.setAmountOrder(amountProduct);
            order.setDestination(customer.getAddress());
            order.setStatusOrder(0);
            order.setCustomer(customer);
            orderService.save(order);
            for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
                orderProductService.saveOrderProduct(new OrderProduct(order, entry.getKey(), entry.getValue()));
            }
        }


//        Khi chưa logout nhưng thêm sản phẩm vào giỏ hàng
        if (amountProduct != cart.countTotalProductQuantity() && accountCurrent.equals(principal.getName()) && cart.countTotalProductQuantity() > 0) {
            orderProductService.removeListOrderProductById(order.getId());
            amountProduct = cart.countTotalProductQuantity();
            order.setAmountOrder(amountProduct);
            order.setStatusOrder(0);
            orderService.save(order);
            for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
                orderProductService.saveOrderProduct(new OrderProduct(order, entry.getKey(), entry.getValue()));
            }
        }

//        Lấy cart của tài khoản hiện tại dưới database
        if (principal != null) {
            List<OrderProduct> orderProducts = orderProductService.findListById(order.getId());
            Map<Product, Integer> products = new HashMap<>();
            for (OrderProduct orderProduct : orderProducts) {
                products.put(productService.findById(orderProduct.getProduct().getId()), orderProduct.getAmountProduct());
            }
            cart.setProducts(products);
        }

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
