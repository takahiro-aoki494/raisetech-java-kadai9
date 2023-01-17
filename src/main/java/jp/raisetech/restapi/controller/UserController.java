package jp.raisetech.restapi.controller;

import jp.raisetech.restapi.entity.Users;
import jp.raisetech.restapi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Users> getUsers() {
        List<Users> users = userService.findAll();
        return users;
    }

    @GetMapping("/users/{id}")
    public Users getUser(@PathVariable int id) throws Exception {
        return userService.findById(id);
    }
}
