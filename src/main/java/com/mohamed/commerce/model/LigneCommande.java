package com.mohamed.commerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "lignecommande")
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Lignecommande_ID")
    private Integer id;

    @Column(name = "prixUnitaire")
    private  Integer prixUnitaire;

    @Column(name = "qte")
    private BigDecimal qte;

    @ManyToOne
    @JoinColumn(name = "Commande_ID")
    private CommandeClient commandeClient;

    @ManyToOne
    @JoinColumn(name = "Article_ID")
    private Article article;


}
