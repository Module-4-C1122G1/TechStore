package com.techstore.service.IAccountService;

import com.techstore.model.account.Account;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    Account findById(int id);
    void saveAccount(Account account);
    void deleteAccountById(int id);
    UserDetails loadUserByUsername(String userName);
}
