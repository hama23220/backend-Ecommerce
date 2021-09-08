package com.mohamed.commerce.Services;

import com.mohamed.commerce.dto.CommandeClientDto;
import com.mohamed.commerce.dto.LignecommandeDto;
import com.mohamed.commerce.model.EtatCommande;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeClientService {

    CommandeClientDto save(CommandeClientDto dto);

    CommandeClientDto updateEtatCommande(Integer Commande_ID, EtatCommande etatCommande);

    CommandeClientDto updateQuantiteCommande(Integer  Commande_ID, Integer Lignecommande_ID, BigDecimal qte);

    CommandeClientDto updateClient(Integer Commande_ID, Integer User_ID );

    CommandeClientDto updateArticle(Integer Commande_ID ,Integer Lignecommande_ID , Integer Article_ID);

    //delete article==>delete ligne commandeClient
    CommandeClientDto deleteArticle(Integer Commande_ID, Integer Lignecommande_ID);

    CommandeClientDto findById(Integer Commande_ID);

    CommandeClientDto findByCode(String code);

    List<CommandeClientDto> findAll();

    List<LignecommandeDto> findAllLignesCommandesClientByCommandeClientId(Integer Commande_ID);

    void delete(Integer Commande_ID);
}

