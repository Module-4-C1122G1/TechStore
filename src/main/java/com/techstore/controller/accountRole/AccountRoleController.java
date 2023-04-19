package com.techstore.controller.accountRole;

import com.techstore.service.impl.accountRoleService.AccountRoleService;
import com.techstore.service.impl.roleService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountRoleController {
    @Autowired
    private AccountRoleService accountRoleService;
    @GetMapping("admin/account/list-account-role")
    public String showListRole(Model model){
        model.addAttribute("listAccountRole",accountRoleService.getAll());
        return "admin/account/list-account-role";
    }
}
