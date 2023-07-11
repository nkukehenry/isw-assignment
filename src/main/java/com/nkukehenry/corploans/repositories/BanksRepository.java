package com.nkukehenry.corploans.repositories;

import com.nkukehenry.corploans.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanksRepository extends JpaRepository<Bank, Integer> {
}
