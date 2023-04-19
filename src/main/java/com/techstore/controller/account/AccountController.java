package com.techstore.controller.account;

import com.techstore.model.account.Account;
import com.techstore.model.account.AccountRole;
import com.techstore.model.account.Role;
import com.techstore.service.IAccountService.IAccountService;
import com.techstore.service.impl.accountRoleService.AccountRoleService;
import com.techstore.service.impl.roleService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AccountRoleService accountRoleService;

    @GetMapping("")
    public String showListAccount(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Account> listAccount = accountService.getAll(PageRequest.of(page, 4));
        model.addAttribute("page", page);
        model.addAttribute("listAccount", listAccount);
        model.addAttribute("listRole", roleService.getAll());
        model.addAttribute("listAccountRole", accountRoleService.getAll());
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= listAccount.getTotalPages(); i++) {
            pageNumberList.add(i);
        }
        model.addAttribute("pageNumberList", pageNumberList);
        return "admin/account/list";
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
        model.addAttribute("account", accountService.findById(id));
        model.addAttribute("listRole", roleService.getAll());
        return "/admin/account/update";
    }

    @PostMapping("/update")
    public String update(Model model, Account account) {
        accountService.saveAccount(account);
        model.addAttribute("account", account);
        model.addAttribute("msg", "Sửa thành công");
        return "redirect:/admin/account/update";
    }

    @GetMapping("/search")
    public String seachByName(@RequestParam(defaultValue = "0") int page, String name, Model model) {
        Page<Account> listAccount = accountService.findByUserNameContaining(name, PageRequest.of(page, 4));
        if (listAccount.getContent().isEmpty()) {
            model.addAttribute("msg", "Không tìm thấy");
        }
            model.addAttribute("page", page);
            model.addAttribute("name", name);
            model.addAttribute("listAccount", listAccount);
            model.addAttribute("listRole", roleService.getAll());
            model.addAttribute("listAccountRole", accountRoleService.getAll());

        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= listAccount.getTotalPages(); i++) {
            pageNumberList.add(i);
        }
        model.addAttribute("pageNumberList", pageNumberList);
        return "admin/account/list";
    }
}
