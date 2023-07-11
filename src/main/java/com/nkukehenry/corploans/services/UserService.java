package com.nkukehenry.corploans.services;

import com.nkukehenry.corploans.models.User;
import com.nkukehenry.corploans.repositories.UsersRepository;
import com.nkukehenry.corploans.services.contracts.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User getByUserName(String username) {
        return usersRepository.getByUserName(username);
    }

    @Override
    public User getByUserId(Integer userId) {
        return usersRepository.getById(userId);
    }

    @Override
    public List<User> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public User save(User user) {

        return usersRepository.save(user);
    }
}
