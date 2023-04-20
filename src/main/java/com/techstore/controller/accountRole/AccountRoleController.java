package com.techstore.controller.accountRole;

import com.techstore.service.impl.accountRoleService.AccountRoleService;
import com.techstore.service.impl.roleService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountRoleController {
    @Autowired
    private AccountRoleService accountRoleService;
    @GetMapping("admin/account/list-account-role")
    public String showListRole(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String name){
        model.addAttribute("listAccountRole",accountRoleService.getAll(name, PageRequest.of(page,4)));
        return "admin/account/list-account-role";
    }
}
