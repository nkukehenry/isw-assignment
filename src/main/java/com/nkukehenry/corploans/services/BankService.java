package com.nkukehenry.corploans.services;

import com.nkukehenry.corploans.models.Bank;
import com.nkukehenry.corploans.repositories.BanksRepository;
import com.nkukehenry.corploans.services.contracts.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BankService implements IBankService {

    @Autowired
    private BanksRepository banksRepository;

    @Override
    public List<Bank> getBanks() {
        return banksRepository.findAll();
    }

    @Override
    public Bank saveBank(Bank bank) {
        return banksRepository.save(bank);
    }

    @Override
    public Optional<Bank> getBankById(Integer bankId) {
        return banksRepository.findById(bankId);
    }
}
