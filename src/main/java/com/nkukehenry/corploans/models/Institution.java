package com.nkukehenry.corploans.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "institutions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Institution {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

    @Column(name = "institution_name")
    private String institutionName;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

}
