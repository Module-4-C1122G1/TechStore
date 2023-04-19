package com.techstore.service.impl.voucher;

import com.techstore.model.voucher.TypeVoucher;
import com.techstore.repository.voucherRepository.ITypeVoucherRepository;
import com.techstore.service.IVoucherService.ITypeVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeVoucherService implements ITypeVoucherService {

    @Autowired
    private ITypeVoucherRepository typeVoucherRepository;


    @Override
    public List<TypeVoucher> findAllTypeVoucher() {
        return (List<TypeVoucher>) typeVoucherRepository.findAll();
    }

}
