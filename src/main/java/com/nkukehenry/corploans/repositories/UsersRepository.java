package com.nkukehenry.corploans.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {

    public  User getByUserName(String username);
}
