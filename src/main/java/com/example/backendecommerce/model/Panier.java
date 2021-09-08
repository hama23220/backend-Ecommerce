package com.example.backendecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Panier")
public class Panier {

    @Id
    @GeneratedValue
    @Column(name = "idpanier")
    private Integer idpanier;
    @Column(name = "date")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
    private Date date;
    @Column(name = "annee")
    private Integer annee;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "totale")
    private Integer totale;
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "panier", fetch=FetchType.EAGER)
    private List<Lpanier> lpaniers;
}
