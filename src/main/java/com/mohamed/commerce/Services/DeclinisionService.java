package com.mohamed.commerce.Services;

import com.mohamed.commerce.dto.DeclinisionDto;

import java.util.List;

public interface DeclinisionService {

    DeclinisionDto save(DeclinisionDto dto);

    DeclinisionDto findById(Integer Declinision_ID);

    DeclinisionDto findByCouleur(String couleur);

    DeclinisionDto findByTaille(String taille);

    List<DeclinisionDto> findAll();

    void delete(Integer Declinision_ID);
}
