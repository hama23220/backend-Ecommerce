package com.example.backendecommerce.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class user {

    @Column(name = "nom")
    private String nom ;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "tel")
    private String tel;
    @Column(name = "fax")
    private String fax;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "etat")
    private Boolean etat;
    @Column(name = "usertype")
    private String usertype;

}
