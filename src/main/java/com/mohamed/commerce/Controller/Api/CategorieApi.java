package com.mohamed.commerce.Controller.Api;

import com.mohamed.commerce.dto.ArticleDto;
import com.mohamed.commerce.dto.CategorieDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mohamed.commerce.Utils.Constants.APP_ROOT;

@Api("categories")

public interface CategorieApi {

    @GetMapping(value = APP_ROOT + "/categories/allCategorie", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategorieDto> getAllCategorie();

    @GetMapping(value = APP_ROOT + "/sousCategories/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategorieDto> getAllSubCategorie(Integer id);

    @PostMapping(value = APP_ROOT+ "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategorieDto saveCategorie(@RequestBody CategorieDto dto);

    @GetMapping(value = APP_ROOT + "/articles/Categories/{Categorie_ID}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> getAllArticleByCategorie(Integer Categorie_ID);

    @DeleteMapping(value = APP_ROOT + "/categories/delete/{categorie_id}")
    void delete (@PathVariable("categorie_id") Integer id);/*
    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Categorie save(@RequestBody  Categorie dto);

    @GetMapping(value = APP_ROOT + "/categories/{Categorie_ID}", produces = MediaType.APPLICATION_JSON_VALUE)
    Categorie findById(@PathVariable("Categorie_ID") Integer Categorie_ID);

    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Categorie> findAll();

    @DeleteMapping(value = APP_ROOT + "/categories/delete/{Categorie_ID}")
    void delete(@PathVariable("Categorie_ID") Integer Categorie_ID );



 */
}
