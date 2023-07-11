package com.nkukehenry.corploans.models;


import jakarta.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "role_id")
    private String roleId;

    @OneToOne
    private User user;

    @OneToMany
    private Role role;
}
