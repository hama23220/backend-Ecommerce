package com.mohamed.commerce.dto;

import com.mohamed.commerce.model.LigneCommande;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LignecommandeDto {
    private Integer id;
    private  Integer prixUnitaire;
    private BigDecimal qte;
    private CommandeClientDto commandeClient;
    private ArticleDto article;

    public static  LignecommandeDto fromEntity(LigneCommande lignecommande) {
        if (lignecommande == null) {
            return null;
        }
        return LignecommandeDto.builder()
                .id(lignecommande.getId())
                .prixUnitaire(lignecommande.getPrixUnitaire())
                .qte(lignecommande.getQte())
                .commandeClient(CommandeClientDto.fromEntity(lignecommande.getCommandeClient()))
                .article(ArticleDto.fromEntity(lignecommande.getArticle()))
                .build();
    }

    public static LigneCommande toEntity(LignecommandeDto dto) {
        if (dto == null) {
            return null;
        }
        LigneCommande lignecommande = new LigneCommande();
        lignecommande.setId(dto.getId());
        lignecommande.setPrixUnitaire(dto.getPrixUnitaire());
        lignecommande.setQte(dto.getQte());
        lignecommande.setCommandeClient(CommandeClientDto.toEntity(dto.getCommandeClient()));
        lignecommande.setArticle(ArticleDto.toEntity(dto.getArticle()));
        return lignecommande;
    }
}
