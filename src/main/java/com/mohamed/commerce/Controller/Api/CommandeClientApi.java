package com.mohamed.commerce.Controller.Api;

import com.mohamed.commerce.dto.CommandeClientDto;
import com.mohamed.commerce.dto.LignecommandeDto;
import com.mohamed.commerce.model.EtatCommande;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.mohamed.commerce.Utils.Constants.APP_ROOT;

@Api("CommandeClient")
public interface CommandeClientApi {

    @PostMapping(APP_ROOT + "/commandesclients/create")
    CommandeClientDto save(CommandeClientDto dto);

    @PatchMapping(APP_ROOT + "/commandesclients/update/etat/{Commande_ID}/{etatCommande}")
    CommandeClientDto updateEtatCommande(@PathVariable("Commande_ID")Integer Commande_ID,@PathVariable("etatCommande") EtatCommande etatCommande);


    @PatchMapping(APP_ROOT + "/commandesclients/update/quantite/{Commande_ID}/{Lignecommande_ID}/{qte}")
    CommandeClientDto updateQuantiteCommande(@PathVariable("Commande_ID")Integer  Commande_ID,@PathVariable("Lignecommande_ID") Integer Lignecommande_ID,@PathVariable("qte") BigDecimal qte);

    @PatchMapping(APP_ROOT + "/commandesclients/update/client/{Commande_ID}/{User_ID}")
    CommandeClientDto updateClient(@PathVariable("Commande_ID")Integer Commande_ID, @PathVariable("User_ID")Integer User_ID );

    @PatchMapping(APP_ROOT + "/commandesclients/update/article/{Commande_ID}/{Lignecommande_ID}/{Article_ID}")
    CommandeClientDto updateArticle(@PathVariable("Commande_ID")Integer Commande_ID ,@PathVariable("Lignecommande_ID")Integer Lignecommande_ID , @PathVariable("Article_ID")Integer Article_ID);

    //delete article==>delete ligne commandeClient
    @DeleteMapping(APP_ROOT + "/commandesclients/delete/article/{Commande_ID}/{Lignecommande_ID}")
    CommandeClientDto deleteArticle(@PathVariable("Commande_ID")Integer Commande_ID,@PathVariable("Lignecommande_ID") Integer Lignecommande_ID);

    @GetMapping(APP_ROOT + "/commandesclients/{Commande_ID}")
    CommandeClientDto findById(@PathVariable("Commande_ID") Integer Commande_ID);

    @GetMapping(APP_ROOT + "/commandesclients/filter/{code}")
    CommandeClientDto findByCode(@PathVariable("code") String code);

    @GetMapping(APP_ROOT + "/commandesclients/all")
    List<CommandeClientDto> findAll();

    @GetMapping(APP_ROOT + "/commandesclients/lignesCommande/{Commande_ID}")
    List<LignecommandeDto> findAllLignesCommandesClientId(@PathVariable("Commande_ID") Integer Commande_ID);

    @DeleteMapping(APP_ROOT + "/commandesclients/delete/{Commande_ID}")
    void delete(@PathVariable("Commande_ID") Integer Commande_ID);
}
