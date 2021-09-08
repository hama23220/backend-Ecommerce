package com.mohamed.commerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "declinision")
public class Declinision {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Declinision_ID")
    private Integer id;

    @Column(name = "couleur")
    private String couleur;

    @Column(name = "taille")
    private String taille;


}
