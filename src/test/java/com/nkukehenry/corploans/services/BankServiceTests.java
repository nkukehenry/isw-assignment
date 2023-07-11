package com.nkukehenry.corploans.services;

import com.nkukehenry.corploans.models.Bank;
import com.nkukehenry.corploans.repositories.BanksRepository;
import com.nkukehenry.corploans.services.contracts.IBankService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BankServiceTests {

    private IBankService bankService;
    private BanksRepository banksRepository;
    private Bank dummyBank;

    @BeforeEach
    void setup(){

        banksRepository = mock(BanksRepository.class);
        bankService    = new BankService(banksRepository);
        dummyBank = mock(Bank.class);

        when(banksRepository.findById(anyInt())).thenReturn(Optional.of(dummyBank));
    }

    @Test
    void testGetBankByIdReturnsABank(){
        int userId = 1;
        Optional<Bank> bankOptional = bankService.getBankById(userId);
        Assertions.assertTrue(bankOptional.isPresent());
    }

    @Test
    void testGetLoansReturnsLoanList(){

        List<Bank> banks = new ArrayList<>();
        banks.add(dummyBank);

        when(banksRepository.findAll()).thenReturn(banks);

        List<Bank> returnedBanks = bankService.getBanks();
        Assertions.assertTrue(!returnedBanks.isEmpty() && returnedBanks.contains(dummyBank));
    }

    @Test
    void testSaveBankByIdReturnsABank(){

        when(banksRepository.save(dummyBank)).thenReturn(dummyBank);

        Bank returnedBank = bankService.saveBank(dummyBank);
        Assertions.assertTrue(returnedBank instanceof  Bank);
        Assertions.assertSame(dummyBank,returnedBank);
    }

}
