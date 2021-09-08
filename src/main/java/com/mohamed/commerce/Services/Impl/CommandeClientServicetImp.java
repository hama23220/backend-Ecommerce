package com.mohamed.commerce.Services.Impl;

import com.mohamed.commerce.Exception.EntityNotFoundException;
import com.mohamed.commerce.Exception.ErrorCodes;
import com.mohamed.commerce.Exception.InvalidEntityException;
import com.mohamed.commerce.Exception.InvalidOperationException;
import com.mohamed.commerce.Repository.ArticleRepository;
import com.mohamed.commerce.Repository.CommandeClientRepository;
import com.mohamed.commerce.Repository.LigneCommandeRepository;
import com.mohamed.commerce.Repository.UserRepository;
import com.mohamed.commerce.Services.CommandeClientService;
import com.mohamed.commerce.Services.StockService;
import com.mohamed.commerce.dto.*;
import com.mohamed.commerce.model.*;
import com.mohamed.commerce.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientServicetImp implements CommandeClientService {

    private CommandeClientRepository commandeClientRepository;
    private LigneCommandeRepository ligneCommandeRepository ;
    private UserRepository userRepository;
    private ArticleRepository articleRepository;
    private StockService stockService;

    @Autowired
    public CommandeClientServicetImp(CommandeClientRepository commandeClientRepository, LigneCommandeRepository ligneCommandeRepository, UserRepository userRepository, ArticleRepository articleRepository, StockService stockService) {
        this.commandeClientRepository = commandeClientRepository;
        this.ligneCommandeRepository = ligneCommandeRepository;
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
        this.stockService = stockService;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        List<String> errors = CommandeClientValidator.validator(dto);
        if (!errors.isEmpty()){
            log.error("Commande client n'ext pas valide");
            throw  new InvalidEntityException("La commande client n'ext pas valide", ErrorCodes.CommandeClient_NOT_VALID,errors);
        }
        Optional<User> user = userRepository.findById(dto.getUser().getId());
        if ((user.isEmpty())) {
            log.warn("Aucun user exite avec cette Id {}",dto.getUser().getId());
            throw  new EntityNotFoundException("Aucun user avec l'id {} existe dans la BD"+dto.getUser().getId(),ErrorCodes.User_NOT_FOUND);

        }
        List<String> articleErrors= new ArrayList<>();
        if (dto.getLigneCommandes()!=null){
            dto.getLigneCommandes().forEach(ligCmdClt ->{
                if (ligCmdClt.getArticle()!=null){
                    Optional<Article> article = articleRepository.findById(ligCmdClt.getArticle().getId());
                    if (article.isEmpty()){
                        articleErrors.add("L'article avec l'id"+ligCmdClt.getArticle().getId());
                    }else {
                        articleErrors.add("Imposible d'enregister une commande avec un article Null");

                    }
                }
            });
        }
        if (!articleErrors.isEmpty()){
            log.warn("");
            throw new InvalidEntityException("Article n'existe pas dans BD",ErrorCodes.ARTICLE_NOT_FOUND,articleErrors);

        }
        dto.setDate(Instant.now());
        CommandeClient saveCmdClt= commandeClientRepository.save(CommandeClientDto.toEntity(dto));
        if (dto.getLigneCommandes()!=null){
            dto.getLigneCommandes().forEach(ligCmdClt -> {
                LigneCommande ligneCommande =ligCmdClt ;
                ligneCommande.setCommandeClient(saveCmdClt);
                LigneCommande Lcommande = ligneCommandeRepository.save(ligneCommande);

            });
        }
        return CommandeClientDto.fromEntity(saveCmdClt);
    }

    @Override
    public CommandeClientDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande) {
        chekIdCommande(idCommande);
        if (!StringUtils.hasLength(String.valueOf(etatCommande))){
            log.error("L'etat de la commande client est null");
            throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec un etat null",
                    ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
        CommandeClientDto commandeClient= chechEtatCommande(idCommande);
        commandeClient.setEtatCommande(etatCommande);
        CommandeClient saveCmdClient= commandeClientRepository.save(CommandeClientDto.toEntity(commandeClient));
        if ((commandeClient.isCommandeLivree())){
            updateStock(idCommande);
        }
        return CommandeClientDto.fromEntity(saveCmdClient);
    }

    @Override
    public CommandeClientDto updateQuantiteCommande(Integer Commande_ID, Integer Lignecommande_ID, BigDecimal qte) {
        chekIdCommande(Commande_ID);
        chekIdLigneCommande(Lignecommande_ID);
        if (qte==null||qte.compareTo(BigDecimal.ZERO)==0){
            log.error("L'id de la ligne commande est null ou zero");
            throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec quantite null ou zero",
                    ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
        CommandeClientDto commandeClient = chechEtatCommande(Commande_ID);
        Optional<LigneCommande> ligneCommandeOptional = findLigneCommandeClient(Lignecommande_ID);

        LigneCommande ligneCommande = ligneCommandeOptional.get();
        ligneCommande.setQte(qte);
        ligneCommandeRepository.save(ligneCommande);
        return commandeClient;
    }

    @Override
    public CommandeClientDto updateClient(Integer Commande_ID, Integer User_ID) {
        chekIdCommande(Commande_ID);
        if (User_ID==null){
            log.error("L'id du client est null");
            throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec un un Id client null",
                    ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
        CommandeClientDto commandeClient = chechEtatCommande(Commande_ID);
        Optional<User> user =userRepository.findById(User_ID);
        if (user.isEmpty()){
            throw new EntityNotFoundException(
                    "Aucun client n'a ete trouve avec l'id"+User_ID,ErrorCodes.CommandeClient_NOT_FOUND
            );
        }
        commandeClient.setUser(UserDto.fromEntity(user.get()));
        return CommandeClientDto.fromEntity(
                commandeClientRepository.save(CommandeClientDto.toEntity(commandeClient))
        );
    }

    @Override
    public CommandeClientDto updateArticle(Integer Commande_ID, Integer Lignecommande_ID, Integer Article_ID) {
        chekIdCommande(Commande_ID);
        chekIdLigneCommande(Lignecommande_ID);
        checkIdArticle(Article_ID ,"nouvel");

        CommandeClientDto commandeClient = chechEtatCommande(Commande_ID);

        Optional<LigneCommande> ligneCommande = findLigneCommandeClient(Lignecommande_ID);

        Optional<Article> article = articleRepository.findById(Article_ID);

        if (article.isEmpty()){
            throw new EntityNotFoundException(
                    "Aucune article n'a ete trouve avec l'ID "+Article_ID,ErrorCodes.ARTICLE_NOT_FOUND
            );
        }
        LigneCommande ligneCommandeTosave =ligneCommande.get();
        ligneCommandeTosave.setArticle(article.get());
        ligneCommandeRepository.save(ligneCommandeTosave);

        return commandeClient;

    }

    @Override
    public CommandeClientDto deleteArticle(Integer Commande_ID, Integer Lignecommande_ID) {
    chekIdCommande(Commande_ID);
    chekIdLigneCommande(Lignecommande_ID);
    CommandeClientDto commandeClient= chechEtatCommande(Commande_ID);
    findLigneCommandeClient(Lignecommande_ID);
    ligneCommandeRepository.deleteById(Lignecommande_ID);
    return commandeClient;
    }

    @Override
    public CommandeClientDto findById(Integer Commande_ID) {
        if(Commande_ID== null){
            log.error("L'id de commande client est null");
            return null;
        }
        return commandeClientRepository.findById(Commande_ID)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException("Acune commande n'est ete trouve avec l'id"+Commande_ID,ErrorCodes.CommandeClient_NOT_FOUND));

    }

    @Override
    public CommandeClientDto findByCode( String code) {
        if (!StringUtils.hasLength(code)){
            log.error("L'id de commande Client est null ");
            return null;
        }
        return commandeClientRepository.findCommandeClientByCodeCommande(code)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException("Acune commande n'est ete trouve avec le code"+code,ErrorCodes.CommandeClient_NOT_FOUND));
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDto::fromEntity)
                .collect((Collectors.toList()));
    }

    @Override
    public List<LignecommandeDto> findAllLignesCommandesClientByCommandeClientId(Integer Commande_ID) {

        return  ligneCommandeRepository.findAllByCommandeClientId(Commande_ID).stream()
                .map(LignecommandeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer Commande_ID) {
        if (Commande_ID== null){
            log.error("Id Commande client est null");
        }
        List<LigneCommande> ligneCommandes = ligneCommandeRepository.findAllByArticleId(Commande_ID);
        if(!ligneCommandes.isEmpty()){
            throw  new InvalidOperationException("Empossible de supprimer une commande client deja utilisee",
                    ErrorCodes.Categorie_ALREADY_IN_USE);
        }
        commandeClientRepository.deleteById(Commande_ID);
    }


    private Optional<LigneCommande> findLigneCommandeClient(Integer Lignecommande_ID){
        Optional<LigneCommande> ligneCommande = ligneCommandeRepository.findById(Lignecommande_ID);
        if (ligneCommande.isEmpty()){
            throw  new EntityNotFoundException(
                    "Aucune ligne commande n'a ete trouve avec l'id "+Lignecommande_ID,ErrorCodes.CommandeClient_NOT_FOUND
            );

        }
        return ligneCommande;
    }

    private  void  chekIdCommande(Integer Commande_ID){
        if (Commande_ID==null){
            log.error("L'id commande client est null");
            throw  new InvalidOperationException("Impossible de modifier l'etat de commande avec un ID null",ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
    }
    private void  chekIdLigneCommande(Integer Lignecommande_ID){
        if (Lignecommande_ID==null){
            log.error("L'id ligne commande est null");
            throw  new InvalidOperationException("Impossible de modifier l'etat de la commande avec une ligne de commande null",ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
    }
    private void checkIdArticle(Integer Article_ID,String msg){
        if (Article_ID==null){
            log.error("L'id de"+msg+"est null");
            throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec un "+msg+" Id article null",ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);

        }
    }
    private  void updateStock(Integer Commande_ID){
        List<LigneCommande>  ligneCommandes= ligneCommandeRepository.findAllByCommandeClientId(Commande_ID);
        ligneCommandes.forEach(lig->{
            effectuerSortie(lig);
        });
    }
    private CommandeClientDto chechEtatCommande(Integer Commande_ID ){
        CommandeClientDto commandeClient = findById(Commande_ID);
        if (commandeClient.isCommandeLivree()){
            throw  new InvalidOperationException("Impossible de modifier la commande lorsqu'elle est livree",ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
        }
        return commandeClient;
    }
    private void effectuerSortie(LigneCommande ligneCommande ){
        StockDto stockDto = StockDto.builder()
                .article(ArticleDto.fromEntity(ligneCommande.getArticle()))
                .date(Instant.now())
                .typeMvt(TypeMvtStock.SORTIE)
                .quantite(ligneCommande.getQte())
                .build();
        stockService.sortieStock(stockDto);
    }
}
