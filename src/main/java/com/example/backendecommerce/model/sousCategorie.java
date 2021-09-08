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
@Table(name = "sousCategorie")
public class sousCategorie {

    @Id
    @GeneratedValue
    @Column(name = "idsouscat")
    private Integer idsouscat;

    @Column(name = "codesouscat")
    private String codesouscat;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "rang")
    private int rang;

    @ManyToOne
    @JoinColumn(name = "idcategorie")
    private Categories category;

    @OneToMany(mappedBy = "scategory")
    private List<Article> articles;

}
