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
@Table(name = "Categories")
public class Categories {

    @Id
    @GeneratedValue
    @Column(name = "idcategorie")
    private Integer idcategorie;

    @Column(name = "codecategorie")
    private String codecategorie;

    @Column(name = "libelle")
    private String libelle;

    @OneToMany(mappedBy = "category")
    private List<sousCategorie> sousCategories;
}
