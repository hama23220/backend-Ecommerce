package com.mohamed.commerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Article_ID")
    private Integer id;

    @Column(name = "codeArticle")
    private String codeArticle;

    @Column(name = "prixUnitaireHt")
    private BigDecimal prixUnitaireHt;

    @Column(name = "prixUnitaireTtc")
    private BigDecimal prixUnitaireTtc;

    @Column(name = "image")
    private  String image;

    @Column(name = "description")
    private  String description;

    @Column(name = "libelle")
    private  String libelle;

    @Column(name = "TVA")
    private Integer TVA;

    @OneToMany(mappedBy = "article")
    private  List<Stock> stocks;

    @OneToMany
    private List<Declinision> declinisions;

    @OneToMany
    private List<Brand> brands;

    @OneToMany(mappedBy = "article")
    private List<LigneCommande> ligneCommandes;

    @ManyToOne
    @JoinColumn(name = "Categorie_ID",referencedColumnName = "Categorie_ID")
    private Categorie categorie;


}
