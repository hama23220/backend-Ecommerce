package com.mohamed.commerce.Controller;

import com.mohamed.commerce.Controller.Api.ArticleApi;
import com.mohamed.commerce.Services.ArticleService;
import com.mohamed.commerce.dto.ArticleDto;
import com.mohamed.commerce.dto.LignecommandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ArticleController implements ArticleApi {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }

    @Override
    public ArticleDto findById(Integer Article_ID) {
        return articleService.findById(Article_ID);
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return  articleService.findAll();
    }

    @Override
    public List<LignecommandeDto> findHistoriqueCommandeClient(Integer Article_ID) {
        return articleService.findHistoriqueCommandeClient(Article_ID);
    }

    @Override
    public List<ArticleDto> findAllArticleByIdCategorie(Integer Categorie_ID) {
        return articleService.findAllArticleByIdCategorie(Categorie_ID);
    }

    @Override
    public void delete(Integer Article_ID) {
    articleService.delete( Article_ID);
    }
}
