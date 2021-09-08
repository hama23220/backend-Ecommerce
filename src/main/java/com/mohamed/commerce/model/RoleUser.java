package com.mohamed.commerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roleUser")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;
    @Column(name = "roleName")
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User user;
}
