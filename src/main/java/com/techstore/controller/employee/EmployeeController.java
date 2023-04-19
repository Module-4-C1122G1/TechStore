package com.techstore.controller.employee;

import com.techstore.dto.EmployeeDTO;
import com.techstore.model.employee.Employee;
import com.techstore.service.IEmployeeService.IDepartmentService;
import com.techstore.service.IEmployeeService.IEmployeeService;
import com.techstore.service.IEmployeeService.IPositionService;
import com.techstore.service.IGenderService.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/admin/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IGenderService iGenderService;
    @Autowired
    private IDepartmentService iDepartmentService;
    @Autowired
    private IPositionService iPositionService;

    @GetMapping("")
    public String showListEmployee(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam(defaultValue = "") String name) {
        Pageable sortedPage = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<Employee> employeePage = iEmployeeService.findAll(name, (PageRequest) sortedPage);
        model.addAttribute("employeeList", employeePage);
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= employeePage.getTotalPages(); i++) {
            pageNumberList.add(i);
        }
        model.addAttribute("pageNumberList", pageNumberList);
        return "/employee/list_employee";
    }

    @GetMapping("/detail")
    public String detailEmployee(@RequestParam int id, Model model) {
        Employee employee = iEmployeeService.findById(id).get();
        model.addAttribute("employee", employee);
        return "/employee/detail_employee";
    }

    @GetMapping("/create")
    public String showFormCreateEmployee(Model model) {
        model.addAttribute("employeeDTO", new EmployeeDTO());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("departmentList", iDepartmentService.findAll());
        model.addAttribute("genderList", iGenderService.findAll());
        return "/employee/create_employee";
    }

    @PostMapping("/create")
    public String createEmployee(@Valid @ModelAttribute("employeeDTO") EmployeeDTO employeeDTO, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "/employee/create_employee";
        } else {
            iEmployeeService.createEmployee(employeeDTO);
            redirect.addFlashAttribute("msg","Thêm mới thành công");
            return "redirect:/admin/employee";
        }
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam int deleteId) {
        Employee employee = iEmployeeService.findById(deleteId).get();
        iEmployeeService.deleteEmployee(employee);
        return "redirect:/admin/employee";
    }

    @GetMapping("/edit")
    public String showFormEditEmployee(@RequestParam int id, Model model) {
        model.addAttribute("employeeDTO", iEmployeeService.findById(id));
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("departmentList", iDepartmentService.findAll());
        model.addAttribute("genderList", iGenderService.findAll());
        return "/employee/edit_employee";
    }

    @PostMapping("/edit")
    public String editEmployee(@Valid @ModelAttribute("employeeDTO") EmployeeDTO employeeDTO, BindingResult bindingResult,RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "/employee/edit_employee";
        } else {
            iEmployeeService.editEmployee(employeeDTO);
            redirect.addFlashAttribute("msg","Chỉnh Sửa Thành Công");
            return "redirect:/admin/employee";
        }
    }
}
