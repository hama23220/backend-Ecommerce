package com.mohamed.commerce.Services;

import com.mohamed.commerce.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto dto);

    EntrepriseDto findById(Integer Entreprise_ID);

    List<EntrepriseDto> findAll();

    void delete(Integer Entreprise_ID);
}
