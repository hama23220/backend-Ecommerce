package com.example.backendecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Lpanier")
public class Lpanier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idlpanier")
    private long idlpanier;
    @Column(name = "numero")
    private int numero ;
    @Column(name = "code")
    private String code;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "pv")
    private int pv;
    @Column(name = "qte")
    private double qte;
    @Column(name = "tva")
    private int tva;
    @Column(name = "montht")
    private double montht;
    @Column(name = "monttva")
    private double monttva;
    @Column(name = "montttc")
    private double montttc;
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private Panier panier;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "articleid")
    private Article article;
}
