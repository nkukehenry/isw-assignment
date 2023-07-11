package com.nkukehenry.corploans.repositories;

import com.nkukehenry.corploans.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoansRepository extends JpaRepository<Loan, Integer> {

}