package com.techstore.service.impl.voucher;
import com.techstore.dto.UpdateVoucherDTO;
import com.techstore.dto.VoucherDTO;
import com.techstore.model.voucher.Voucher;
import com.techstore.repository.voucherRepository.IVoucherRepository;
import com.techstore.service.IVoucherService.IVoucherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class VoucherService implements IVoucherService {
    @Autowired
    private IVoucherRepository voucherRepository;


    @Override
    public Page<Voucher> findAll(String search, Pageable pageable) {
        return voucherRepository.findVouchersByNameVoucherContaining(search, pageable);
    }

    @Override
    public void delete(int id) {
       voucherRepository.deleteById(id);
    }

    @Override
    public void save(VoucherDTO voucherDTO) {
        Date date1= null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(voucherDTO.getExpiredDate());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Voucher voucher = new Voucher();
        BeanUtils.copyProperties(voucherDTO,voucher);
        voucher.setExpiredDate(date1);
            voucherRepository.save(voucher);
    }

    public Voucher findById(int id) {
        return voucherRepository.findById(id).get();
    }

    @Override
    public void update(UpdateVoucherDTO updateVoucherDTO, int id) {
        Date date2= null;
        try {
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(updateVoucherDTO.getExpiredDate());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Voucher voucher = voucherRepository.findById(id).get();
        voucher.setExpiredDate(date2);
        BeanUtils.copyProperties(updateVoucherDTO, voucher);
        voucherRepository.save(voucher);
    }
}
