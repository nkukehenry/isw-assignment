package com.nkukehenry.corploans.services.contracts;


import com.nkukehenry.corploans.models.Bank;
import com.nkukehenry.corploans.models.Loan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface  IBankService {

    public List<Bank> getBanks();
    public Bank saveBank( Bank bank);

    public Optional<Bank> getBankById(Integer bankId);
}
