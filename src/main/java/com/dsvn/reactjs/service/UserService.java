package com.dsvn.reactjs.service;

import com.dsvn.reactjs.entity.User;
import com.dsvn.reactjs.repository.UserRepository;
import com.dsvn.reactjs.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends ModelMapperService<User, UserRequest>{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeamService teamService;
    @Autowired
    private RoleService roleService;

    public List<User> findAll(String name) {
        return userRepository.getUserByName(name);
    }

    public User save(UserRequest request) {
        User user = convertRequestToEntity(request);
        user.setTeam(teamService.findById(request.getTeam()));
        user.setRole(roleService.findById(request.getRole()));
        return userRepository.save(user);
    }

    public void delete(List<Integer> ids) {
        userRepository.delete(ids);
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User update(UserRequest request) {
        return save(request);
    }
}
