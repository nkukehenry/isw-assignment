package com.nkukehenry.corploans.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "user_institutions")
public class UserInstitution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institution_id")
    private Institution institution;

}
