package com.techstore.service.IAccountService;

import com.techstore.model.account.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IAccountService {
    List<Account> getAll();
    Page<Account> getAll(PageRequest pageRequest);

    Page<Account> getAll(String name, PageRequest pageRequest);

    Account findById(int id);
    void saveAccount(Account account);
    void deleteAccountById(int id);
    Account findAccountByName(String name);
    UserDetails loadUserByUsername(String userName);

    Page<Account> findByUserNameContaining(String name, PageRequest pageRequest);
}
