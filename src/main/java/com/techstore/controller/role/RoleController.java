package com.techstore.controller.role;

import com.techstore.service.impl.roleService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;
    @GetMapping("admin/account/list-role")
    public String showListRole(Model model){
        model.addAttribute("listRole",roleService.getAll());
        return "admin/account/list-role";
    }
}
