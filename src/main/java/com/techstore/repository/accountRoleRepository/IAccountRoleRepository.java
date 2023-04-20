package com.techstore.repository.accountRoleRepository;

import com.techstore.model.account.Account;
import com.techstore.model.account.AccountRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IAccountRoleRepository extends JpaRepository<AccountRole, Integer> {
    List<AccountRole> findByAccount(Account account);
    AccountRole findAccountRoleByAccount(Account account);

//    @Query(value = "select * from student  where name_student like :name_student", nativeQuery = true)
    Page<AccountRole> findAllByAccountContains(String name,PageRequest pageRequest);
//    Page<AccountRole> findAllByUserNameContaining(String name, PageRequest pageRequest);

    Page<AccountRole> findByAccount_UserNameContaining(String name,PageRequest pageRequest);
}
