package com.nkukehenry.corploans.services.contracts;
import com.nkukehenry.corploans.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface  IUserService {

    public User getByUserName(String username);

    public Optional<User> getByUserId(Integer userId);

    public List<User> getAll();

    public User save(User user);

}
