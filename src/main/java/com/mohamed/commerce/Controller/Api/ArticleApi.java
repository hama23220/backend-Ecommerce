package com.mohamed.commerce.Controller.Api;

import com.mohamed.commerce.dto.ArticleDto;
import com.mohamed.commerce.dto.LignecommandeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mohamed.commerce.Utils.Constants.APP_ROOT;

@Api("articles")
public interface ArticleApi {

    @PostMapping(value = APP_ROOT+ "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un article", notes = "Cette methode permet d'enregistrer ou modifier un article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet article cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet article n'est pas valide")
    })
    ArticleDto save(@RequestBody ArticleDto dto);

    @GetMapping(value = APP_ROOT + "/articles/{Article_ID}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article par ID", notes = "Cette methode permet de chercher un article par son ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec l'ID fourni")
    })
    ArticleDto findById(@PathVariable("Article_ID")Integer Article_ID);

    @GetMapping(value = APP_ROOT + "/articles/filter/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article par CODE", notes = "Cette methode permet de chercher un article par son CODE", response =
            ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec le CODE fourni")
    })
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

    @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des articles", notes = "Cette methode permet de chercher et renvoyer la liste des articles qui existent "
            + "dans la BDD", responseContainer = "List<ArticleDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des article / Une liste vide")
    })
    List<ArticleDto> findAll();

    @GetMapping(value = APP_ROOT + "/articles/historique/commandeclient/{Article_ID}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LignecommandeDto> findHistoriqueCommandeClient(@PathVariable("Article_ID") Integer Article_ID );

    @GetMapping(value = APP_ROOT + "/articles/filter/category/{Categorie_ID}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAllArticleByIdCategorie (Integer Categorie_ID);

    @DeleteMapping(value = APP_ROOT + "/articles/delete/{Article_ID}")
    @ApiOperation(value = "Supprimer un article", notes = "Cette methode permet de supprimer un article par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete supprime")
    })
    void delete (@PathVariable("Article_ID")Integer Article_ID);
}
