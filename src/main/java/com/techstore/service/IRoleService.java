package com.techstore.service;

import com.techstore.model.account.Account;

import java.util.List;

public interface IRoleService {
    List<Account> getAll();

    Account getById(int id);

    void createAccount(Account account);


}
