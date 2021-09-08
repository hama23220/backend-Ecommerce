package com.mohamed.commerce.Services;

import com.mohamed.commerce.dto.ArticleDto;
import com.mohamed.commerce.dto.CategorieDto;

import java.util.List;

public interface CategorieService {

    List<CategorieDto> getAllSubCategorie(Integer parentid);

    List<CategorieDto> getAllCategorie();


    CategorieDto saveCategorie(CategorieDto dto);

    List<ArticleDto> getAllArticleByCategorie(Integer Categorie_ID);

    void delete (Integer Categorie_ID);


/*
    public Categorie save(Categorie dto) ;
    public Categorie findById(Integer Categorie_ID);
    public Categorie findByCode(String code);
    public List<Categorie> findAll();
    public void delete(Integer Categorie_ID);
    public boolean isChildCategorie(Categorie categorie, Categorie parent);
    public void addChildCategory(Categorie categorie, Categorie parent);
    public void removeChildCategorie(Categorie categorie, Categorie parent);
    public Set<Categorie> collectLeafChildren();


 */
}
