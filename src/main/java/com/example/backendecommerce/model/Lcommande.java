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
@Table(name = "Lcommande")
public class Lcommande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idlcommande")
    private long idlcommande;
    @Column(name = "numero")
    private int numero ;
    @Column(name = "qte")
    private String qte;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idcommande")
    private Commande commande;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "articleid")
    private Article article;

}
