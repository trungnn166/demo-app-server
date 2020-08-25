package com.dsvn.reactjs.service;

import com.dsvn.reactjs.entity.Role;
import com.dsvn.reactjs.entity.Team;
import com.dsvn.reactjs.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    public List<Role> getAll() {
        return roleRepository.findByDeletedAtIsNull();
    }
}
