package com.techstore.service.impl.accountRoleService;

import com.techstore.model.account.Account;
import com.techstore.model.account.AccountRole;
import com.techstore.repository.accountRoleRepository.IAccountRoleRepository;
import com.techstore.service.IAccountRoleService.IAccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountRoleService implements IAccountRoleService {

    @Autowired
    private IAccountRoleRepository accountRoleRepository;

    @Override
    public void saveAccountRole(AccountRole accountRole) {
        accountRoleRepository.save(accountRole);
    }

    @Override
    public List<AccountRole> getAll() {
        return accountRoleRepository.findAll();
    }
    @Override
    public Page<AccountRole> getAll(String name, PageRequest pageRequest) {
        return accountRoleRepository.findByAccount_UserNameContaining(name, pageRequest);
    }

    @Override
    public AccountRole getById(int id) {
        return accountRoleRepository.findById(id).get();
    }

    @Override
    public AccountRole getByAccount(Account account) {
        return accountRoleRepository.findAccountRoleByAccount(account);
    }


}
