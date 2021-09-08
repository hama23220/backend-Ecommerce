package com.mohamed.commerce.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "Commandeclient")
public class CommandeClient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Commande_ID")
    private Integer id;

    @Column(name = "codeCommande")
    private   String codeCommande;

    @Column(name = "libelle")
    private   String libelle;

    @Column(name = "totale")
    private Integer totale;

    @Column(name = "date")
    private Instant date;

    @Column(name = "etatcommande")
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User user;

    @OneToMany(mappedBy = "commandeClient")
    private List<LigneCommande> ligneCommandes;

}
