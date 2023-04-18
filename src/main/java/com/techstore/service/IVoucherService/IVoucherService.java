package com.techstore.service.IVoucherService;

import com.techstore.dto.UpdateVoucherDTO;
import com.techstore.dto.VoucherDTO;
import com.techstore.model.voucher.Voucher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IVoucherService {
    Page<Voucher> findAll(String search, Pageable pageable);

    void delete(int id);

    void save(VoucherDTO voucherDTO);


    Voucher findById(int id);

    void update(UpdateVoucherDTO updateVoucherDTO, int id);
}
