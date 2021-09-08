package com.mohamed.commerce.Services.Impl;

import com.mohamed.commerce.Exception.ErrorCodes;
import com.mohamed.commerce.Exception.InvalidEntityException;
import com.mohamed.commerce.Exception.InvalidOperationException;
import com.mohamed.commerce.Repository.ArticleRepository;
import com.mohamed.commerce.Repository.CategorieRepository;
import com.mohamed.commerce.Services.CategorieService;
import com.mohamed.commerce.dto.ArticleDto;
import com.mohamed.commerce.dto.CategorieDto;
import com.mohamed.commerce.model.Article;
import com.mohamed.commerce.model.Categorie;
import com.mohamed.commerce.validator.CategorieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategorieServiceImp implements CategorieService {

    private CategorieRepository categorieRepository;
    private ArticleRepository articleRepository;
    @Autowired
    public CategorieServiceImp(CategorieRepository categorieRepository, ArticleRepository articleRepository) {
        this.categorieRepository = categorieRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public List<CategorieDto> getAllSubCategorie(Integer parentid) {

        return categorieRepository.findByParent_Id(parentid).stream()
                .map(CategorieDto::fromEntity).collect(Collectors.toList());
    }
    @Override
    public List<CategorieDto> getAllCategorie() {
        List<Categorie> CategoryList = categorieRepository.findByParentIsNull();

        return categorieRepository.findByParentIsNull().stream()
                .map(CategorieDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CategorieDto saveCategorie(CategorieDto dto) {
        List<String> errors = CategorieValidator.validator(dto);
        if (!errors.isEmpty()){
            log.error("categorie n'existe pas {}",dto);
            throw  new InvalidEntityException("Categorie n'est pas valid", ErrorCodes.Categorie_NOT_VALID);

        }


        return CategorieDto.fromEntity(categorieRepository.save(CategorieDto.toEntity(dto)));
    }

    @Override
    public List<ArticleDto> getAllArticleByCategorie(Integer Categorie_ID) {
        return articleRepository.findAllByCategorieId(Categorie_ID).stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer Categorie_ID) {
        if (Categorie_ID== null){
            log.error("Id categorie est null");
        }
        List<Article> articles = articleRepository.findAllByCategorieId(Categorie_ID);
        if (!articles.isEmpty()){
            throw new InvalidOperationException("Impossible de supprimer un categorie deja utiliser dans article",ErrorCodes.ARTICLE_ALREADY_IN_USE);

        }
        categorieRepository.deleteById(Categorie_ID);
    }


}
