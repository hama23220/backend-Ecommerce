package com.mohamed.commerce.Controller;

import com.mohamed.commerce.Controller.Api.CommandeClientApi;
import com.mohamed.commerce.Services.CommandeClientService;
import com.mohamed.commerce.dto.CommandeClientDto;
import com.mohamed.commerce.dto.LignecommandeDto;
import com.mohamed.commerce.model.EtatCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CommandeClientController implements CommandeClientApi {
    private CommandeClientService commandeClientService;

    @Autowired
    public CommandeClientController(CommandeClientService commandeClientService) {
        this.commandeClientService = commandeClientService;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        return commandeClientService.save(dto);
    }

    @Override
    public CommandeClientDto updateEtatCommande(Integer Commande_ID, EtatCommande etatCommande) {
        return commandeClientService.updateEtatCommande(Commande_ID,etatCommande);
    }

    @Override
    public CommandeClientDto updateQuantiteCommande(Integer Commande_ID, Integer Lignecommande_ID, BigDecimal qte) {
        return commandeClientService.updateQuantiteCommande(Commande_ID ,Lignecommande_ID,qte);    }



    @Override
    public CommandeClientDto updateClient(Integer Commande_ID, Integer User_ID) {
        return commandeClientService.updateClient(Commande_ID,User_ID);
    }

    @Override
    public CommandeClientDto updateArticle(Integer Commande_ID, Integer Lignecommande_ID, Integer Article_ID) {
        return commandeClientService.updateArticle(Commande_ID,Lignecommande_ID,Article_ID);
    }

    @Override
    public CommandeClientDto deleteArticle(Integer Commande_ID, Integer Lignecommande_ID) {
        return commandeClientService.deleteArticle(Commande_ID,Lignecommande_ID);
    }

    @Override
    public CommandeClientDto findById(Integer Commande_ID) {
        return commandeClientService.findById(Commande_ID);
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        return commandeClientService.findByCode(code);
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientService.findAll();
    }

    @Override
    public List<LignecommandeDto> findAllLignesCommandesClientId(Integer Commande_ID) {
        return commandeClientService.findAllLignesCommandesClientByCommandeClientId(Commande_ID);
    }

    @Override
    public void delete(Integer Commande_ID) {
    commandeClientService.delete(Commande_ID);
    }
}
