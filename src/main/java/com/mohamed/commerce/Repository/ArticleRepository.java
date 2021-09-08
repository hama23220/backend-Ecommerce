package com.mohamed.commerce.Repository;

import com.mohamed.commerce.dto.ArticleDto;
import com.mohamed.commerce.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,Integer> {


    Optional<Article> findByCodeArticle(String codeArticle);
    List<Article> findAllByCategorieId(Integer Categorie_ID );
}
