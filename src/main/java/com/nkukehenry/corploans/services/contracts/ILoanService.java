package com.nkukehenry.corploans.services.contracts;

import com.nkukehenry.corploans.models.Loan;
import com.nkukehenry.corploans.models.LoanSchedule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ILoanService {

    public  List<Loan> getLoans();
    public Loan saveLoan( Loan loan);

    public Optional<Loan> getLoanById(Integer loanId);

    public List<LoanSchedule> generateLoanSchedule(Integer loanId);
}
