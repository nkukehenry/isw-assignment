package com.nkukehenry.corploans.services;

import com.nkukehenry.corploans.models.User;
import com.nkukehenry.corploans.repositories.UsersRepository;
import com.nkukehenry.corploans.services.contracts.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTests {

    private IUserService userService;
    private UsersRepository usersRepository;
    private User dummyUser;

    @BeforeEach
    void setup(){

        usersRepository = mock(UsersRepository.class);
        userService    = new UserService(usersRepository);
        dummyUser = mock(User.class);

        when(usersRepository.findById(anyInt())).thenReturn(Optional.of(dummyUser));
    }


    @Test
    void testGetUserByIdReturnsAUser(){

        int userId = 1;
        Optional<User> userOpt = userService.getByUserId(userId);
        Assertions.assertTrue(userOpt.isPresent());
    }
}
