package com.techstore.repository.accountRoleRepository;

import com.techstore.model.account.Account;
import com.techstore.model.account.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAccountRoleRepository extends JpaRepository<AccountRole, Integer> {
    List<AccountRole> findByAccount(Account account);
}
