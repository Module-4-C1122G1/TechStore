package com.techstore.service.IAccountRoleService;

import com.techstore.model.account.Account;
import com.techstore.model.account.AccountRole;
import com.techstore.model.account.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IAccountRoleService {
    void saveAccountRole(AccountRole accountRole);
    Page<AccountRole> getAll(String name, PageRequest pageRequest);
    List<AccountRole> getAll();

    AccountRole getById(int id);
    AccountRole getByAccount(Account account);

}
