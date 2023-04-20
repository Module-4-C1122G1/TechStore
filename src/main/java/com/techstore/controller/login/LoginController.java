package com.techstore.controller.login;

import com.techstore.model.account.Account;
import com.techstore.model.customer.Customer;
import com.techstore.service.IAccountService.IAccountService;
import com.techstore.service.ICustomerService.ICustomerService;
import com.techstore.service.IGenderService.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IGenderService genderService;

    @GetMapping("/register")
    public String showFormRegister(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("account", new Account());
        return "login/register";
    }

    @PostMapping("/register/save")
    public String saveCustomerAndAccount(@ModelAttribute Account account, @ModelAttribute Customer customer, @RequestParam String dateofbirth,
                                         @RequestParam int gender, @RequestParam String address) {
        customer.setDateOfBirth(Date.valueOf(dateofbirth));
        customer.setAddress(address);
        customer.setAccount(account);
        customer.setGender(genderService.findById(gender));
        accountService.saveAccount(account);
        customerService.saveCustomer(customer);
        return "redirect:/login";
    }
    @GetMapping("/login-successful")
    public String loginSuccessful() {
        return "redirect:/";
    }
    @GetMapping("/logout-successful")
    public String logoutSuccessful() {
        return "redirect:/";
    }
}