package com.mohamed.commerce.Services;

import com.mohamed.commerce.dto.ArticleDto;
import com.mohamed.commerce.dto.LignecommandeDto;

import java.util.List;

public interface ArticleService {
    ArticleDto save(ArticleDto dto);

    ArticleDto findById(Integer Article_ID);

    ArticleDto findByCodeArticle(String codeArticle);

    List<ArticleDto> findAll();

    List<LignecommandeDto> findHistoriqueCommandeClient(Integer Article_ID );

    List<ArticleDto> findAllArticleByIdCategorie (Integer Categorie_ID);

    void delete (Integer Article_ID);

}
