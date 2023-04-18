package com.techstore.repository;

import com.techstore.model.voucher.Voucher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVoucherRepository extends PagingAndSortingRepository<Voucher, Integer> {
    Page<Voucher> findVouchersByNameVoucherContaining(String search, Pageable pageable);

}
