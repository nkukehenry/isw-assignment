package com.nkukehenry.userengine.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "loan")
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loan_name")
    private String loanName;

    @Column(name = "loan_amount")
    private double loanAmount;

    @Column(name = "interest_rate")
    private double interestRate;

    @Column(name = "loan_duration")
    private int loanDuration;

    // The user that the loan belons to
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
