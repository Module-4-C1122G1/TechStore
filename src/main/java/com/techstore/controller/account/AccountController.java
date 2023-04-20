package com.techstore.controller.account;

import com.techstore.model.account.Account;
import com.techstore.model.account.AccountRole;
import com.techstore.service.IAccountService.IAccountService;
import com.techstore.service.impl.accountRoleService.AccountRoleService;
import com.techstore.service.impl.roleService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

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
    public String showListAccount(Model model, @RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String name) {
        Page<AccountRole> listAccountRole = accountRoleService.getAll(name,PageRequest.of(page, 4));
        if (listAccountRole.getContent().isEmpty()){
            model.addAttribute("msg","Không tìm thấy");
        }else {
            model.addAttribute("listAccountRole", listAccountRole);
        }
        model.addAttribute("listAccountRole", listAccountRole);
        model.addAttribute("name",name);
        model.addAttribute("page", page);
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= listAccountRole.getTotalPages(); i++) {
            pageNumberList.add(i);
        }
        model.addAttribute("pageNumberList", pageNumberList);
        return "/admin/account/list-account";
    }

    @GetMapping("/detail/{id}")
    public String showDetailAccount(@PathVariable(required = false) int id, Model model, RedirectAttributes redirect) {
        model.addAttribute("account", accountService.findById(id));
        return "redirect:/account/list";
    }

    @GetMapping("/delete/{id}")
    public String removeAccount(@PathVariable int id,Model model) {
        accountService.deleteAccountById(id);
        return "redirect:/admin/account";
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
}
