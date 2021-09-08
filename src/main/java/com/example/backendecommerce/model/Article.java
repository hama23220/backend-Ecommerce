package com.example.backendecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Article")
public class Article {

    @Id
    @GeneratedValue
    @Column(name = "articleid")
    private Integer articleid ;
    @Column(name = "codeabarre")
    private Integer codeabarre;
    @Column(name = "image")
    private String image;
    @Column(name = "description")
    private String description;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "stockinitial")
    private Integer stockinitial;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "TVA")
    private Integer TVA;

    @ManyToOne
    @JoinColumn(name = "idsouscat")
    private sousCategorie scategory;

    @OneToMany(mappedBy = "article")
    private List<Lcommande> ligneCommande;

    @OneToMany(mappedBy = "article")
    private List<Lpanier> lignepanier;

}
