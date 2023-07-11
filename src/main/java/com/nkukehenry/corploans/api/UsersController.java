package com.nkukehenry.corploans.api;

import com.nkukehenry.corploans.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    
    @GetMapping
    public List<User> getUsers() {

        List list = new ArrayList<User>();
        list.add(new User());

        return list;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {

        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User add(@RequestBody User user) {

      return  new User();
    }

}
