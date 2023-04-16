package com.techstore.service.impl.account;

import com.techstore.model.account.Account;
import com.techstore.repository.account.IAccountRepository;
import com.techstore.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository iAccountRepository;
    @Override
    public List<Account> getAll() {
        return (List<Account>) iAccountRepository.findAll();
    }

    @Override
    public Account getById(int id) {
        return iAccountRepository.findById(id).get();
    }

    @Override
    public Account createAccount(Account account) {
       return iAccountRepository.save(account);
    }

    @Override
    public void removeAccount(int id) {
        iAccountRepository.deleteById(id);
    }


}
