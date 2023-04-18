package com.techstore.service.IRoleService;

import com.techstore.model.account.Account;
import com.techstore.model.account.Role;

import java.util.List;

public interface IRoleService {
    List<Role> getAll();

    Account getById(int id);
}
