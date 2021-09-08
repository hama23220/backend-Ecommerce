package com.mohamed.commerce.Controller;

import com.mohamed.commerce.Controller.Api.DeclinisionApi;
import com.mohamed.commerce.Services.DeclinisionService;
import com.mohamed.commerce.dto.DeclinisionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeclinisionControlleur implements DeclinisionApi {

    private DeclinisionService declinisionService;

    @Autowired
    public DeclinisionControlleur(DeclinisionService declinisionService) {
        this.declinisionService = declinisionService;
    }

    @Override
    public DeclinisionDto save(DeclinisionDto dto) {
        return declinisionService.save(dto);
    }

    @Override
    public DeclinisionDto findById(Integer Declinision_ID) {
        return declinisionService.findById(Declinision_ID);
    }

    @Override
    public DeclinisionDto findByCouleur(String couleur) {
        return declinisionService.findByCouleur(couleur);
    }

    @Override
    public DeclinisionDto findByTaille(String taille) {
        return declinisionService.findByTaille(taille);
    }

    @Override
    public List<DeclinisionDto> findAll() {
        return declinisionService.findAll();
    }

    @Override
    public void delete(Integer Declinision_ID) {
    declinisionService.findById(Declinision_ID);
    }
}
