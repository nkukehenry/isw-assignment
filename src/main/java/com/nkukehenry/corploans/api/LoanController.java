package com.nkukehenry.corploans.api;

import com.nkukehenry.corploans.models.Loan;
import com.nkukehenry.corploans.services.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

  @Autowired
  private ILoanService loanService;


    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Loan> getLoans() {
      return  loanService.getLoans();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Loan add(@RequestBody Loan loan) {
       return  loanService.saveLoan(loan);
    }


}
