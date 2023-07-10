package com.nkukehenry.userengine.api;

import com.nkukehenry.userengine.models.Loan;
import com.nkukehenry.userengine.models.User;
import com.nkukehenry.userengine.services.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {

  private LoanService loanService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Loan add(@RequestBody Loan loan) {
       return  loanService.saveLoan(loan);
    }

}
