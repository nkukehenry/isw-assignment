package com.nkukehenry.userengine.services;

import com.nkukehenry.userengine.models.Loan;
import com.nkukehenry.userengine.models.LoanSchedule;
import com.nkukehenry.userengine.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public Optional<Loan> getLoanById(int loanId) {

        Loan loan = loanRepository.findById(loanId).orElse(null);
        return Optional.of(loan);
    }

    public List<LoanSchedule> generateLoanSchedule(Integer loanId) {

        Optional<Loan> optLoan= getLoanById(loanId);
        Loan loan = optLoan.get();

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
