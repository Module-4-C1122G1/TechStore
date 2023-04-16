package com.techstore.repository.accountRepository;

import com.techstore.model.account.Account;
import com.techstore.model.account.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepository extends PagingAndSortingRepository<Account, Integer> {
    Account findByUserName(String usename);
}
