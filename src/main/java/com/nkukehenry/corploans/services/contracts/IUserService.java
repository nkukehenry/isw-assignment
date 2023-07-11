package com.nkukehenry.corploans.services.contracts;
import com.nkukehenry.corploans.models.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface  IUserService {

    public User getByUserName(String username);

    public User getByUserId(Integer userId);

    public List<User> getAll();

    public User save(User user);

}
