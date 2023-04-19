package com.techstore.service.impl.accountService;

import com.techstore.model.account.Account;
import com.techstore.model.account.AccountRole;
import com.techstore.repository.AccountRoleRepository.IAccountRoleRepository;
import com.techstore.repository.accountRepository.IAccountRepository;
import com.techstore.service.IAccountService.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements IAccountService, UserDetailsService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IAccountRoleRepository accountRoleRepository;

    @Override
    public List<Account> findAll() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Account findById(int id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void deleteAccountById(int id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account findAccountByName(String useName) {
        return accountRepository.findByUserName(useName);
    }

    @Override
    public AccountRole findAccountRoleByAccount(Account account) {
        return accountRoleRepository.findAccountRoleByAccount(account);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //Tìm đối tượng đang đăng nhập trong DB
        Account account = accountRepository.findByUserName(userName);
        System.out.println("username: " + account.getUserName() + ", password: " + account.getPassword());

        if (account == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + account);

        List<AccountRole> accountRoles = accountRoleRepository.findByAccount(account);
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (accountRoles != null) {
            for (AccountRole accountRole : accountRoles) {
                GrantedAuthority authority = new SimpleGrantedAuthority(accountRole.getRole().getRoleName());
                grantList.add(authority);
            }
        }
        UserDetails userDetails = new User(account.getUserName(),
                account.getPassword(), grantList);

        return new User(userDetails.getUsername(), new BCryptPasswordEncoder().encode(userDetails.getPassword()), grantList);
    }
}
