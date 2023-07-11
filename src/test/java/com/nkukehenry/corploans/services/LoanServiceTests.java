package com.nkukehenry.corploans.services;

import com.nkukehenry.corploans.models.Loan;
import com.nkukehenry.corploans.models.LoanSchedule;
import com.nkukehenry.corploans.repositories.LoansRepository;
import com.nkukehenry.corploans.services.contracts.ILoanService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoanServiceTests {

    private ILoanService loanService;
    private  LoansRepository loanRepository;
    private Loan dummyLoan;

    @BeforeEach
    void setup(){

        loanRepository = mock(LoansRepository.class);
        loanService    = new LoanService(loanRepository);
        dummyLoan = mock(Loan.class);

        when(loanRepository.findById(anyInt())).thenReturn(Optional.of(dummyLoan));
    }

    @Test
    void testGetLoanByIdReturnsALoan(){

        int loanId = 1;
        Optional<Loan> loanOpt = loanService.getLoanById(loanId);
        Assertions.assertTrue(loanOpt.isPresent());
    }

    @Test
    void testGetLoanByIdReturnsNoLoanForInvalidId(){

        when(loanRepository.findById(null)).thenReturn(Optional.empty());

        Optional<Loan> loanOpt = loanService.getLoanById(null);
        Assertions.assertTrue(loanOpt.isEmpty());
    }

    @Test
    void testGetLoansReturnsLoanList(){

        List<Loan> loans = new ArrayList<>();
        loans.add(dummyLoan);

        when(loanRepository.findAll()).thenReturn(loans);

        List<Loan> returnedLoans = loanService.getLoans();
        Assertions.assertTrue(!returnedLoans.isEmpty() && returnedLoans.contains(dummyLoan));
    }

    @Test
    void testGetLoansScheduleReturnsSchedule(){

        int loanId = 1;

        List<LoanSchedule> returnedSchedule = loanService.generateLoanSchedule(loanId);
        Assertions.assertTrue(returnedSchedule.isEmpty());
    }
}
