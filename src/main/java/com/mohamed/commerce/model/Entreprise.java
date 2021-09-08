package com.mohamed.commerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "entreprise")
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Entreprise_ID")
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "codefiscal")
    private String codeFiscal;

    @Column(name = "photo")
    private String photo;

    @Column(name = "email")
    private String email;

    @Column(name = "numtel")
    private String numTel;

    @Column(name = "siteweb")
    private String steWeb;

    @OneToMany(mappedBy = "entreprise")
    private List<User> users;
}
