package com.mohamed.commerce.Controller.Api;

import com.mohamed.commerce.dto.EntrepriseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mohamed.commerce.Utils.Constants.ENTREPRISE_ENDPOINT;

@Api("entreprises")
public interface EntrepriseApi {

    @PostMapping(ENTREPRISE_ENDPOINT + "/create")
    EntrepriseDto save(@RequestBody EntrepriseDto dto);

    @GetMapping(ENTREPRISE_ENDPOINT + "/{Entreprise_ID}")
    EntrepriseDto findById( @PathVariable("Entreprise_ID") Integer Entreprise_ID);

    @GetMapping(ENTREPRISE_ENDPOINT + "/all")
    List<EntrepriseDto> findAll();

    @DeleteMapping(ENTREPRISE_ENDPOINT + "/delete/{Entreprise_ID}")
    void delete(@PathVariable("Entreprise_ID") Integer Entreprise_ID);
}
