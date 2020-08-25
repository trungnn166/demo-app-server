package com.dsvn.reactjs.api;

import com.dsvn.reactjs.entity.User;
import com.dsvn.reactjs.request.UserRequest;
import com.dsvn.reactjs.response.ResourceResponse;
import com.dsvn.reactjs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserApi {
    @Autowired
    private UserService userService;
    @GetMapping("")
    public ResourceResponse getAll(@RequestParam(name = "name", defaultValue = "") String name) {
        List<User> users = userService.findAll(name);
        return new ResourceResponse(users);
    }

    @PostMapping("")
    public ResourceResponse save(@RequestBody UserRequest request) {
        User result = userService.save(request);
        return  new ResourceResponse(result);
    }

    @DeleteMapping("")
    public ResourceResponse delete(@RequestParam("ids") List<Integer> ids) {
        userService.delete(ids);
        return new ResourceResponse(200, "Delete success");
    }

    @GetMapping("/{id}")
    public ResourceResponse show(@PathVariable("id") Integer id) {
        User user = userService.findById(id);
        return new ResourceResponse(user);
    }

    @PutMapping("")
    public ResourceResponse update(@RequestBody UserRequest request) {
        User result = userService.update(request);
        return  new ResourceResponse(result);
    }
}
