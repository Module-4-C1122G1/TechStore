package com.techstore.controller.voucher;

import com.techstore.model.voucher.Voucher;
import com.techstore.service.IVoucherService.IVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admin/voucher")
@CrossOrigin("*")
public class VoucherRestController {
    @Autowired
    private IVoucherService voucherService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<Voucher> getListVoucher(@Valid @RequestParam(defaultValue = "", required = false)
                                        @PageableDefault(size = 5)Pageable pageable,
                                        String search){
        return voucherService.findAll(search, pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("detail/{id}")
    public Voucher getVoucherDetail(@PathVariable int id){
        return voucherService.findById(id);
    }
}