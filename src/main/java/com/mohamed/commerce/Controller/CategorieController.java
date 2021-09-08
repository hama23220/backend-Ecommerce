package com.mohamed.commerce.Controller;

import com.mohamed.commerce.Controller.Api.CategorieApi;
import com.mohamed.commerce.Services.CategorieService;
import com.mohamed.commerce.dto.ArticleDto;
import com.mohamed.commerce.dto.CategorieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategorieController implements CategorieApi {

    private CategorieService categorieService ;

    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @Override
    public List<CategorieDto> getAllCategorie() {
        return categorieService.getAllCategorie();
    }

    @Override
    public List<CategorieDto> getAllSubCategorie(Integer id) {
        return categorieService.getAllSubCategorie(id);
    }

    @Override
    public CategorieDto saveCategorie(CategorieDto dto) {
        return  categorieService.saveCategorie(dto);
    }

    @Override
    public List<ArticleDto> getAllArticleByCategorie(Integer Categorie_ID) {
        return categorieService.getAllArticleByCategorie(Categorie_ID);
    }

    @Override
    public void delete(Integer Categorie_ID) {
        categorieService.delete(Categorie_ID);
    }




/*


    @Override
    public CategorieDto save(CategorieDto dto) {
        return categorieService.save(dto);
    }

    @Override
    public CategorieDto findById(Integer Categorie_ID) {
        return categorieService.findById(Categorie_ID);
    }



    @Override
    public List<CategorieDto> findAll() {
        return categorieService.findAll();
    }



    @Override
    public void delete(Integer Categorie_ID) {
    categorieService.delete(Categorie_ID);
    }

 */
}
