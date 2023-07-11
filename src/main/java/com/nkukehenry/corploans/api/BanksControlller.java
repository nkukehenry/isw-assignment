package com.nkukehenry.corploans.api;

import com.nkukehenry.corploans.models.Bank;
import com.nkukehenry.corploans.models.Loan;
import com.nkukehenry.corploans.services.contracts.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/banks")
public class BanksControlller {

    @Autowired
    private IBankService bankService;

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Bank> getBanks() {
        return  bankService.getBanks();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Bank getBanks(@RequestParam Integer bankId) {

        Optional<Bank> bankOpt = bankService.getBankById(bankId);
        return (bankOpt.isPresent())? bankOpt.get(): null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bank add(@RequestBody Bank bank) {
        return  bankService.saveBank(bank);
    }

}
