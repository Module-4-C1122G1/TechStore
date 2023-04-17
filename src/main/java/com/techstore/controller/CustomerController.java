package com.techstore.controller;

import com.techstore.model.customer.Customer;
import com.techstore.service.ICustomerService;
import com.techstore.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private ICustomerTypeService iCustomerTypeService;
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String list(Model model, @PageableDefault(sort = {"id"}, size = 2, direction = Sort.Direction.DESC) Pageable pageable, @RequestParam(defaultValue = "") String search) {
        model.addAttribute("list", iCustomerService.list(pageable, search));
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= iCustomerService.list(pageable, search).getTotalPages(); i++) {
            pageNumberList.add(i);
        }
        model.addAttribute("pageNumberList", pageNumberList);
        return "customer/list";
    }

    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("typeList", iCustomerTypeService.list());
        return "customer/create";
    }

    @PostMapping("create")
    public String create(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("typeList", iCustomerTypeService.list());
            model.addAttribute("msg", "Tạo mới khách hàng thất bại");
            return "customer/create";
        }
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Tạo mới khách hàng thành công");
        return "redirect:/customer";
    }

    @GetMapping("update/{id}")
    public String updateForm(Model model, @PathVariable int id) {
        model.addAttribute("customer", iCustomerService.findByID(id));
        model.addAttribute("typeList", iCustomerTypeService.list());
        return "customer/update";
    }
    @PostMapping("update")
    public String update(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            model.addAttribute("typeList", iCustomerTypeService.list());
            model.addAttribute("msg", "Chỉnh sửa khách hàng thất bại");
            return "customer/update";
        }
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Chỉnh sửa khách hàng thành công");
        return "redirect:/customer";
    }
    @GetMapping("delete")
    public String delete(@RequestParam int id,RedirectAttributes redirectAttributes){
        iCustomerService.delete(id);
        redirectAttributes.addFlashAttribute("msg","Xóa khách hàng thành công");
        return "redirect:/customer";
    }
}
