package com.mohamed.commerce.Controller;

import com.mohamed.commerce.Controller.Api.EntrepriseApi;
import com.mohamed.commerce.Services.EntrepriseService;
import com.mohamed.commerce.dto.EntrepriseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class EntrepriseController implements EntrepriseApi {

    private EntrepriseService entrepriseService;

    @Autowired
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        return entrepriseService.save(dto);
    }

    @Override
    public EntrepriseDto findById(Integer Entreprise_ID) {
        return entrepriseService.findById(Entreprise_ID);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Integer Entreprise_ID) {
        entrepriseService.delete(Entreprise_ID);   }
}
