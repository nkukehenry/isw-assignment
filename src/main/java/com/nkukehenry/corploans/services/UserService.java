package com.nkukehenry.corploans.services;

import com.nkukehenry.corploans.repositories.UsersRepository;
import com.nkukehenry.corploans.services.contracts.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
    public Optional<User> getByUserId(Integer userId) {
       return usersRepository.findById(userId);
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
