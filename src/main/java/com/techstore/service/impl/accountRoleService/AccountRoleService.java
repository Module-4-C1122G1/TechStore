package com.techstore.service.impl.accountRoleService;

import com.techstore.model.account.Account;
import com.techstore.model.account.AccountRole;
import com.techstore.repository.accountRoleRepository.IAccountRoleRepository;
import com.techstore.service.IAccountRoleService.IAccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountRoleService implements IAccountRoleService {

    @Autowired
    private IAccountRoleRepository iAccountRoleRepository;
    @Override
    public List<AccountRole> getAll() {
        return iAccountRoleRepository.findAll();
    }

    @Override
    public AccountRole getById(int id) {
        return iAccountRoleRepository.findById(id).get();
    }

    @Override
    public AccountRole getByAccount(Account account) {
        return iAccountRoleRepository.findAccountRoleByAccount(account);
    }

}
