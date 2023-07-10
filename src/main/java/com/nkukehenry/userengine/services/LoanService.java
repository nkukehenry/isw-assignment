package com.nkukehenry.userengine.services;

import com.nkukehenry.userengine.models.Loan;
import com.nkukehenry.userengine.models.LoanSchedule;
import com.nkukehenry.userengine.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {
    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan getLoanById(Long loanId) {

        return loanRepository.findById(loanId).orElse(null);
    }

    public List<LoanSchedule> generateLoanSchedule(Long loanId) {

        Loan loan = getLoanById(loanId);

        if (loan == null) {
            throw new IllegalArgumentException("Loan not found");
        }

        double loanAmount = loan.getLoanAmount();
        double interestRate = loan.getInterestRate();
        int loanDuration = loan.getLoanDuration();

        double remainingBalance = loanAmount;

        // Assuming interest rate is an annual rate
        double monthlyInterestRate = interestRate / 12;

        List<LoanSchedule> loanSchedules = new ArrayList<>();

        for (int i = 1; i <= loanDuration; i++) {

            double interestAmount  = remainingBalance * monthlyInterestRate;
            double principalAmount = calculatePrincipalAmount(loanAmount, interestAmount, loanDuration,remainingBalance, i);
            double paymentAmount   = interestAmount + principalAmount;

            remainingBalance -= principalAmount;

            LoanSchedule loanSchedule = new LoanSchedule();
            loanSchedule.setInstallmentNumber(i);
            loanSchedule.setPaymentAmount(paymentAmount);
            loanSchedule.setInterestAmount(interestAmount);
            loanSchedule.setPrincipalAmount(principalAmount);
            loanSchedule.setRemainingBalance(remainingBalance);

            loanSchedules.add(loanSchedule);
        }

        return loanSchedules;
    }

    private double calculatePrincipalAmount(double loanAmount, double interestAmount, int loanDuration,double remainingBalance, int installmentNumber) {

        // Principal amount based on the loan amount, interest amount, and number of installments
        double principalAmount = loanAmount / loanDuration;

        if (installmentNumber == loanDuration) {
            // Add any remaining balance to the last installment
            principalAmount += remainingBalance;
        }

        return principalAmount;
    }

}
