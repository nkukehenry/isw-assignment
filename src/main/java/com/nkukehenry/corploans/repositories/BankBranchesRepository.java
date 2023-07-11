package com.nkukehenry.corploans.repositories;

import com.nkukehenry.corploans.models.BankBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankBranchesRepository extends JpaRepository<BankBranch,Integer> {
}
