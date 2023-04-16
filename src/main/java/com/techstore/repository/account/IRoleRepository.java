package com.techstore.repository.account;

import com.techstore.model.account.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface IRoleRepository extends PagingAndSortingRepository<Role,Integer> {
}
