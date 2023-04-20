package com.techstore.controller.voucher;

import com.techstore.dto.VoucherDTO;
import com.techstore.model.voucher.TypeVoucher;
import com.techstore.model.voucher.Voucher;
import com.techstore.service.IVoucherService.IVoucherService;
import org.springframework.beans.BeanUtils;
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
    public VoucherDTO getVoucherDetail(@PathVariable int id){
        Voucher voucher = voucherService.findById(id);
        VoucherDTO voucherDTO = new VoucherDTO();
        voucherDTO.setTypeVoucher(new TypeVoucher());
        BeanUtils.copyProperties(voucher.getTypeVoucher(), voucherDTO.getTypeVoucher());
        BeanUtils.copyProperties(voucher,voucherDTO);
        return voucherDTO;
    }
}
