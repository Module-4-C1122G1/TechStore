package com.techstore.service.impl;

import com.techstore.model.voucher.TypeVoucher;
import com.techstore.repository.ITypeVoucherRepository;
import com.techstore.service.ITypeVoucherService;
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
