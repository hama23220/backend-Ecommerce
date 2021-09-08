package com.example.backendecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Client")
public class Client extends user{
    @Id
    @GeneratedValue
    @Column(name = "idClient")
    private Integer idClient;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "ville")
    private String ville;

}
