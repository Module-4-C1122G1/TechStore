package com.techstore.repository.roleRepository;

import com.techstore.model.account.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRoleRepository extends PagingAndSortingRepository<Role,Integer> {
    Role findRoleById(int id);
}
