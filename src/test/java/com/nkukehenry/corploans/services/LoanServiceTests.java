package com.nkukehenry.corploans.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class LoanServiceTests {

    private LoanService loanService;

    @BeforeEach
    void setup(){

        loanService = mock(LoanService.class);
    }

    @Test
    void testGetLoanByIdReturnsALoan(){

        loanService.getLoanById(1);
    }
}
