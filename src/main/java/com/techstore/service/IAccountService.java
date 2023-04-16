package com.techstore.service;

import com.techstore.model.account.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getAll();

    Account getById(int id);

    Account createAccount(Account account);

    void removeAccount(int id);
}
