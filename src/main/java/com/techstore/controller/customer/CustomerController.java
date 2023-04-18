package com.techstore.controller.customer;

import com.techstore.model.account.Account;
import com.techstore.model.customer.Customer;
import com.techstore.service.ICustomerService.ICustomerService;
import com.techstore.service.ICustomerService.ICustomerTypeService;
import com.techstore.service.IGenderService.IGenderService;
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
@RequestMapping("admin/customer")
public class CustomerController {
    @Autowired
    private IGenderService iGenderService;
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
        iCustomerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("msg", "Tạo mới khách hàng thành công");
        return "redirect:/admin/customer";
    }

    @GetMapping("update/{id}")
    public String updateForm(Model model, @PathVariable int id) {
        model.addAttribute("genderList",iGenderService.findAll());
        model.addAttribute("customer", iCustomerService.findCustomerById(id));
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
        iCustomerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("msg", "Chỉnh sửa khách hàng thành công");
        return "redirect:/admin/customer";
    }
    @GetMapping("delete")
    public String delete(@RequestParam int id,RedirectAttributes redirectAttributes){
        iCustomerService.deleteCustomerById(id);
        redirectAttributes.addFlashAttribute("msg","Xóa khách hàng thành công");
        return "redirect:/admin/customer";
    }
    @PostMapping("reset")
    public String resetPassword(@RequestParam int id,RedirectAttributes redirectAttributes){
        Customer customer=iCustomerService.findCustomerById(id);
        Account account=customer.getAccount();
        account.setPassword("123456");
        redirectAttributes.addFlashAttribute("msg", "Reset mật khẩu thành công");
        return "redirect:/admin/customer";
    }
}
