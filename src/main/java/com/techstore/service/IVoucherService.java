package com.techstore.service;

import com.techstore.dto.VoucherDTO;
import com.techstore.model.voucher.Voucher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IVoucherService {
    Page<Voucher> findAll(String search, Pageable pageable);

    void delete(int id);

    void save(VoucherDTO voucherDTO);


    Voucher findById(int id);

    void update(VoucherDTO voucherDTO, int id);
}
