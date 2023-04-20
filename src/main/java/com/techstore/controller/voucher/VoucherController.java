package com.techstore.controller.voucher;

import com.techstore.dto.UpdateVoucherDTO;
import com.techstore.dto.VoucherDTO;
import com.techstore.model.voucher.Voucher;
import com.techstore.repository.voucherRepository.ITypeVoucherRepository;
import com.techstore.service.IVoucherService.IVoucherService;
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
        model.addAttribute("search", search);
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= voucherPage.getTotalPages(); i++) {
            pageNumberList.add(i);
        }
        model.addAttribute("pageNumberList", pageNumberList);
        return "/voucher/list_voucher";
    }

    @GetMapping("/delete")
    public String deleteVoucher(@RequestParam int id, RedirectAttributes redirect) {
        voucherService.delete(id);
        redirect.addFlashAttribute("msg", "xóa thành công");
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
                                BindingResult bindingResult, Model model,
                                RedirectAttributes redirect ) {
        new VoucherDTO().validate(voucherDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("typeVoucher", typeVoucherRepository.findAll());
            model.addAttribute("messageError", "Thêm mới thất bại");
            return "voucher/create";
        } else {
            voucherService.save(voucherDTO);
            redirect.addFlashAttribute("messageSuccess", "Thêm mới thành công");
            return "redirect:/admin/voucher";
        }
    }

    @GetMapping("/update")
    public String showUpdateVoucher(@RequestParam(required = false) int id, Model model) {
        model.addAttribute("updateVoucherDTO", voucherService.findById(id));
        model.addAttribute("typeVoucher", typeVoucherRepository.findAll());
        return "/voucher/update";

    }

    @PostMapping("/update")
    public String updateVoucher(@Valid @ModelAttribute UpdateVoucherDTO updateVoucherDTO, BindingResult
            bindingResult, RedirectAttributes redirect,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("messageError", "chỉnh sửa thất bại");
            return "voucher/update";
        }
        new UpdateVoucherDTO().validate(updateVoucherDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("messageError", "chỉnh sửa thất bại");
            return "voucher/update";
        } else {
            voucherService.update(updateVoucherDTO, updateVoucherDTO.getId());
            redirect.addFlashAttribute("messageSuccess", "chỉnh sửa thành công ");
            return "redirect:/admin/voucher";
        }
    }

    @GetMapping("/detail/{id}")
    public String detailVoucher(@PathVariable("id") int id, Model model){
        Voucher voucher = voucherService.findById(id);
        model.addAttribute("voucher", voucher);
        return "voucher/detail";
    }

    @ExceptionHandler(Exception.class)
    public String handel(){
        return "voucher/error";
    }
}
