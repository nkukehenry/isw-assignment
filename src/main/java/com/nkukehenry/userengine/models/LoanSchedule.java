package com.nkukehenry.userengine.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanSchedule {

    // The installment number or period
    private int installmentNumber;

    // The total payment amount for this period
    private double paymentAmount;

    // The interest portion of the payment
    private double interestAmount;

    // The principal portion of the payment
    private double principalAmount;

    // The remaining loan balance after the payment
    private double remainingBalance;

}
