package com.techstore.repository.account;

import com.techstore.model.account.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface IAccountRepository extends PagingAndSortingRepository<Account,Integer> {
}
