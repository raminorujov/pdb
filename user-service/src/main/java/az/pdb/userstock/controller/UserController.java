package az.pdb.userstock.controller;

import az.pdb.userstock.domain.User;
import az.pdb.userstock.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @GetMapping
    public List<User> getUserList() {
        return userService.getUserList();
    }
}
