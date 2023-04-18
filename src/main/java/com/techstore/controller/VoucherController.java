package com.techstore.controller;

import com.techstore.dto.VoucherDTO;
import com.techstore.model.voucher.Voucher;
import com.techstore.repository.ITypeVoucherRepository;
import com.techstore.service.IVoucherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
@RequestMapping("/admin/voucher")
public class VoucherController {
    @Autowired
    private IVoucherService voucherService;

    @Autowired
    private ITypeVoucherRepository typeVoucherRepository;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "", required = false) String search,
                           Model model,
                           @PageableDefault(size = 5) Pageable pageable) {
        Sort sort = Sort.by("id").descending();
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        Page<Voucher> voucherPage = voucherService.findAll(search, sortedPageable);
        model.addAttribute("voucherList", voucherPage);
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= voucherPage.getTotalPages(); i++) {
            pageNumberList.add(i);
        }
        model.addAttribute("pageNumberList", pageNumberList);
        return "/voucher/list_voucher";
    }

    @GetMapping("/delete")
    public String deleteVoucher(@RequestParam int id) {
        voucherService.delete(id);
        return "redirect:/admin/voucher";
    }

    @GetMapping("/create")
    public String showCreateVoucher(Model model) {
        model.addAttribute("voucher", new VoucherDTO());
        model.addAttribute("typeVoucher", typeVoucherRepository.findAll());
        return "voucher/create";
    }

    @PostMapping("/create")
    public String createVoucher(@Valid @ModelAttribute("voucher") VoucherDTO voucherDTO,
                                BindingResult bindingResult, Model model) {

        new VoucherDTO().validate(voucherDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("typeVoucher", typeVoucherRepository.findAll());
            return "voucher/create";
        } else {
            voucherService.save(voucherDTO);
            return "redirect:/admin/voucher";
        }
    }

        @GetMapping("/update")
        public String showUpdateVoucher (@RequestParam(required = false) int id, Model model){
            model.addAttribute("voucherDTO", voucherService.findById(id));
            model.addAttribute("typeVoucher", typeVoucherRepository.findAll());
            return "/voucher/update";
        }

        @PostMapping("/update")
        public String updateVoucher (@Valid @ModelAttribute VoucherDTO voucherDTO, BindingResult bindingResult){
            if (bindingResult.hasErrors()) {
                return "voucher/update";
            }
            voucherService.update(voucherDTO,voucherDTO.getId());
            return "redirect:/admin/voucher";
        }
    }
