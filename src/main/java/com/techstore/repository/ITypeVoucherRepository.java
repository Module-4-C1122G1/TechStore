package com.techstore.repository;

import com.techstore.model.voucher.TypeVoucher;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ITypeVoucherRepository extends PagingAndSortingRepository<TypeVoucher, Integer> {
}
