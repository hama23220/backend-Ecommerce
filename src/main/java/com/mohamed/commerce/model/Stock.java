package com.mohamed.commerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Stock_ID")
    private Integer id;

    @Column(name = "date")
    private Instant date;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "typemvt")
    @Enumerated(EnumType.STRING)
    private TypeMvtStock typeMvt;

    @ManyToOne
    @JoinColumn(name = "Article_ID")
    private Article article;

}
