package com.mohamed.commerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mohamed.commerce.model.CommandeClient;
import com.mohamed.commerce.model.EtatCommande;
import com.mohamed.commerce.model.LigneCommande;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
@Builder
@Data
public class CommandeClientDto {
    private Integer id;
    private   String codeCommande;
    private   String libelle;
    private Integer totale;
    private Instant date;
    private UserDto user;
    private EtatCommande etatCommande;
    @JsonIgnore
    private List<LigneCommande> ligneCommandes;

    public static CommandeClientDto fromEntity(CommandeClient  commandeClient){
        if (commandeClient== null){
            return  null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .codeCommande(commandeClient.getCodeCommande())
                .libelle(commandeClient.getLibelle())
                .totale(commandeClient.getTotale())
                .date(commandeClient.getDate())
                .etatCommande(commandeClient.getEtatCommande())
                .user(UserDto.fromEntity(commandeClient.getUser()))
                .build();
    }
    public static  CommandeClient toEntity(CommandeClientDto commandeClientDto){
        if (commandeClientDto== null){
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient .setId(commandeClientDto.getId());
        commandeClient.setCodeCommande(commandeClientDto.getCodeCommande());
        commandeClient.setLibelle(commandeClientDto.getLibelle());
        commandeClient.setTotale(commandeClientDto.getTotale());
        commandeClient.setDate(commandeClientDto.getDate());
        commandeClient.setEtatCommande(commandeClientDto.getEtatCommande());
        commandeClient.setUser(UserDto.toEntity(commandeClientDto.getUser()));
        return commandeClient;
    }
    public boolean isCommandeLivree() {
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }

}
