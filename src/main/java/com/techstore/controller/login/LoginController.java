package com.techstore.controller.login;

import com.techstore.model.account.Account;
import com.techstore.model.account.AccountRole;
import com.techstore.model.customer.Customer;
import com.techstore.model.employee.Employee;
import com.techstore.service.IAccountRoleService.IAccountRoleService;
import com.techstore.service.IAccountService.IAccountService;
import com.techstore.service.ICustomerService.ICustomerService;
import com.techstore.service.IEmployeeService.IEmployeeService;
import com.techstore.service.IGenderService.IGenderService;
import com.techstore.service.IRoleService.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@Controller
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    private IGenderService genderService;
    @Autowired
    private IAccountRoleService accountRoleService;
    @Autowired
    private IRoleService roleService;

    @GetMapping("/register")
    public String showFormRegister(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("account", new Account());
        return "login/register";
    }

    @PostMapping("/register/save")
    public String saveCustomerAndAccount(@Valid @ModelAttribute Account account, BindingResult bindingResultAccount, @Valid @ModelAttribute Customer customer, BindingResult bindingResultCustomer,
                                         @RequestParam int gender, @RequestParam String address,@RequestParam(required = false) String confirmPassword, Model model) {
        if (bindingResultAccount.hasErrors() || bindingResultCustomer.hasErrors()) {
            model.addAttribute("customer", customer);
            model.addAttribute("account", account);
            return "login/register";
        }
//        Check name account similar
        List<Account> accountList = accountService.getAll();
        boolean flag = false;
        for (int i  = 0; i < accountList.size(); i++) {
            if (account.getUserName().equals(accountList.get(i).getUserName())) {
                flag = true;
            }
        }
        if (flag == true && !account.getPassword().equals(confirmPassword)) {
            model.addAttribute("errorUserName", "Tên tài khoản đã có người sử dụng");
            model.addAttribute("errorConfirmPassword", "Xác minh mật khẩu không đúng, vui lòng thử lại");
            return "login/register";
        }
        if (flag == true) {
            model.addAttribute("errorUserName", "Tên tài khoản đã có người sử dụng");
            return "login/register";
        }
//        Check similar password
        if (!account.getPassword().equals(confirmPassword)) {
            model.addAttribute("errorConfirmPassword", "Xác minh mật khẩu không đúng, vui lòng thử lại");
            return "login/register";
        }

//       Set attr customer of account

        customer.setAddress(address);
        customer.setAccount(account);
        customer.setGender(genderService.findById(gender));
        accountService.saveAccount(account);
//        Save role account into database
        AccountRole accountRole = new AccountRole();
        accountRole.setAccount(account);
        accountRole.setRole(roleService.findRoleById(2));
        accountRoleService.saveAccountRole(accountRole);
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