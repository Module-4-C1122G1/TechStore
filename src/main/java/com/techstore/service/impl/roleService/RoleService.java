package com.techstore.service.impl.roleService;

import com.techstore.model.account.Account;
import com.techstore.model.account.Role;
import com.techstore.repository.roleRepository.IRoleRepository;
import com.techstore.service.IAccountService.IAccountService;
import com.techstore.service.IRoleService.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository iRoleRepository;
    @Override
    public List<Role> getAll() {
        return (List<Role>) iRoleRepository.findAll();
    }

    @Override
    public Account getById(int id) {
        return null;
    }
}
