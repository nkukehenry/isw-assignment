package com.nkukehenry.corploans.repositories;

import com.nkukehenry.corploans.models.LoanTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanTransactionsRepository extends JpaRepository<LoanTransaction, Long> {

}
