package com.techstore.service.IAccountRoleService;

import com.techstore.model.account.Account;
import com.techstore.model.account.AccountRole;
import com.techstore.model.account.Role;

import java.util.List;

public interface IAccountRoleService {
    List<AccountRole> getAll();

    AccountRole getById(int id);
    AccountRole getByAccount(Account account);
}
