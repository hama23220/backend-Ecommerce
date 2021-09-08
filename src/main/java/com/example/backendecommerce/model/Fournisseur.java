package com.example.backendecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Fournisseur")
public class Fournisseur extends user{

    @Id
    @GeneratedValue
    @Column(name = "idFournisseur")
    private Integer idFournisseur;

    @Column(name = "matriculeFiscal")
    private String matriculeFiscal;

    @Column(name = "nomboutique")
    private String nomboutique;

    @Column(name = "soldeFournisseur")
    private Double soldeFournisseur;

}
