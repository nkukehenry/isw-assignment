package com.nkukehenry.corploans.api;

import com.nkukehenry.corploans.models.User;
import com.nkukehenry.corploans.services.contracts.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IUserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<User> getUsers() {

        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {

        return userService.getByUserId(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User add(@RequestBody User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return  userService.save(user);
    }

}
