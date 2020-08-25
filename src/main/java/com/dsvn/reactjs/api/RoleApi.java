package com.dsvn.reactjs.api;

import com.dsvn.reactjs.entity.Role;
import com.dsvn.reactjs.response.ResourceResponse;
import com.dsvn.reactjs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleApi {
    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public ResourceResponse getAll() {
        List<Role> roles = roleService.getAll();
        return new ResourceResponse(roles);
    }
}
