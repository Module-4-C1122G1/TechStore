package com.techstore.repository.accountRepository;

import com.techstore.model.account.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepository extends PagingAndSortingRepository<Account, Integer> {
    Page<Account> findAllByUserNameContaining(String name, PageRequest pageRequest);

    Account findByUserName(String userName);
}
