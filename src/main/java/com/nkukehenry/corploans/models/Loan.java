package com.nkukehenry.corploans.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "loan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "loan_name")
    private String loanName;

    @Column(name = "loan_amount")
    private double loanAmount;

    @Column(name = "interest_rate")
    private double interestRate;

    @Column(name = "loan_duration")
    private int loanDuration;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

}
