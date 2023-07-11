package com.nkukehenry.corploans.services;
import com.nkukehenry.corploans.models.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
interface  IUserService {

    public User getByUserName(String username);

    public User getByUserId(Integer userId);

    public Collection<User> getAll();

    public User save(User user);

}
