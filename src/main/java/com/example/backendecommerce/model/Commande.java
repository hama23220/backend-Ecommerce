package com.example.backendecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Commande")
public class Commande {
    @Id
    @GeneratedValue
    @Column(name = "idcommande")
    private Integer idcommande;
    @Column(name = "datecommande")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
    private Date datecommande;
    @Column(name = "annee")
    private Integer annee;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "totalecommande")
    private Integer totalecommande;

    @OneToMany(mappedBy = "commande")
    private List<Lcommande> ligneCommande;
}
