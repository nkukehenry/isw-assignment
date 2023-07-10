package com.nkukehenry.userengine.repositories;

import com.nkukehenry.userengine.models.LoanTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanTransactionRepository extends JpaRepository<LoanTransaction, Long> {

}
