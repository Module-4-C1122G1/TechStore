package com.techstore.controller.account;

import com.techstore.model.account.Account;
import com.techstore.service.IAccountService.IAccountService;
import com.techstore.service.impl.roleService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("admin/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("listAccount", accountService.findAll());
        model.addAttribute("listRole", roleService.getAll());
        return "account/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetailAccount(@PathVariable(required = false) int id, Model model, RedirectAttributes redirect) {
        model.addAttribute("account", accountService.findById(id));
        return "redirect:account/list";
    }

    @PostMapping("/delete")
    public String removeAccount(@RequestParam int id, RedirectAttributes redirect) {
        accountService.deleteAccountById(id);
        redirect.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:";
    }

    @GetMapping("/update/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("account",accountService.findById(id));
        model.addAttribute("listRole",roleService.getAll());
        return "admin/account/update";
    }

    @PostMapping("/update")
    public String update(Model model,Account account) {
        accountService.saveAccount(account);
        model.addAttribute("account", account);
        model.addAttribute("msg", "Account updated successfully");
        return "admin/account/update";
    }
}
