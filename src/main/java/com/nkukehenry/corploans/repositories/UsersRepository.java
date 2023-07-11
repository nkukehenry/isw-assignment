package com.nkukehenry.corploans.repositories;

import com.nkukehenry.corploans.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {

    public  User getByUserName(String username);
}
