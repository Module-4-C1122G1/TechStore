package com.techstore.controller;

import com.techstore.model.account.Account;
import com.techstore.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("listAccount",accountService.getAll());
        return "account/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetailAccount(@PathVariable(required = false) int id, Model model, RedirectAttributes redirect){
        model.addAttribute("account",accountService.getById(id));
        return "redirect:account/list";
    }

    @GetMapping("/create")
    public String showCreateAccount(Model model){
        model.addAttribute("account",new Account());
        return "account/create";
    }

    @PostMapping("/create")
    public String createAccount( RedirectAttributes redirect, Account account){
        accountService.createAccount(account);
        return "redirect:account/list";
    }

    @PostMapping("/delete")
    public String removeAccount(@RequestParam int id,RedirectAttributes redirect){
        accountService.removeAccount(id);
        redirect.addFlashAttribute("msg","Xóa thành công");
        return "redirect:";
    }
}
