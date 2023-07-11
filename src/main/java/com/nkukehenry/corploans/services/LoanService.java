package com.nkukehenry.corploans.services;

import com.nkukehenry.corploans.models.Loan;
import com.nkukehenry.corploans.models.LoanSchedule;
import com.nkukehenry.corploans.repositories.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class LoanService implements  ILoanService {
    private final LoansRepository loanRepository;

    @Autowired
    public LoanService(LoansRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public List<Loan> getLoans() {
        return loanRepository.findAll();
    }

    @Override
    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public Optional<Loan> getLoanById(Integer loanId) {

        Loan loan = loanRepository.findById(loanId).orElse(null);
        return Optional.of(loan);
    }

    @Override
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
