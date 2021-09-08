package com.mohamed.commerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Categorie_ID")
    private Integer id;

    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "parentid")
    private Categorie parent;




    @OneToMany (mappedBy = "categorie")
    private List<Article> articles;

}
