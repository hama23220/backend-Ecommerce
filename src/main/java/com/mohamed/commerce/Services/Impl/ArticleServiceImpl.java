package com.mohamed.commerce.Services.Impl;

import com.mohamed.commerce.Exception.EntityNotFoundException;
import com.mohamed.commerce.Exception.ErrorCodes;
import com.mohamed.commerce.Exception.InvalidEntityException;
import com.mohamed.commerce.Exception.InvalidOperationException;
import com.mohamed.commerce.Repository.ArticleRepository;
import com.mohamed.commerce.Repository.LigneCommandeRepository;
import com.mohamed.commerce.Services.ArticleService;
import com.mohamed.commerce.dto.ArticleDto;
import com.mohamed.commerce.dto.LignecommandeDto;
import com.mohamed.commerce.model.Article;
import com.mohamed.commerce.model.LigneCommande;
import com.mohamed.commerce.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    private LigneCommandeRepository ligneCommandeRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, LigneCommandeRepository ligneCommandeRepository) {
        this.articleRepository = articleRepository;
        this.ligneCommandeRepository = ligneCommandeRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Article not valide {}",dto);
            throw new InvalidEntityException("l'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID);

        }
        return ArticleDto.fromEntity(
                articleRepository.save(
                        ArticleDto.toEntity(dto)));
    }



    @Override
    public ArticleDto findById(Integer Article_ID) {
        if(Article_ID== null){
            log.error("Article id est null");
            return null;
        }
        return articleRepository.findById(Article_ID).
                map(ArticleDto::fromEntity).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucun article avec l'id"+Article_ID+
                                "n'est trouve dans la BDD"
                        ,ErrorCodes.ARTICLE_NOT_FOUND));

    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)){
            log.error("code article n'existe pas");
            return null;
        }
        return articleRepository.findByCodeArticle(codeArticle)
                .map(ArticleDto::fromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException("Aucun article avec le code "
                        +codeArticle+"n'ete trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND)
                );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

   @Override
    public List<LignecommandeDto> findHistoriqueCommandeClient(Integer Article_ID) {
        return ligneCommandeRepository.findAllByArticleId(Article_ID).stream()
                .map(LignecommandeDto::fromEntity)
                .collect(Collectors.toList());
    }




        @Override
        public List<ArticleDto> findAllArticleByIdCategorie(Integer Categorie_ID) {
            return articleRepository.findAllByCategorieId(Categorie_ID).stream()
                    .map(ArticleDto::fromEntity)
                    .collect(Collectors.toList());
        }

    @Override
    public void delete(Integer Article_ID) {
    if (Article_ID== null){
        log.error("Id article est null");
    }

    List<LigneCommande> ligneCommandes = ligneCommandeRepository.findAllByArticleId(Article_ID);
    if (!ligneCommandes.isEmpty()){
        throw new InvalidOperationException("Impossible de supprimer un article deja utlilise dans des commande client",ErrorCodes.ARTICLE_ALREADY_IN_USE);
    }


    articleRepository.deleteById(Article_ID) ;
    }
}
