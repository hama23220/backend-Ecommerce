package com.mohamed.commerce.Services.Impl;

import com.mohamed.commerce.Exception.EntityNotFoundException;
import com.mohamed.commerce.Exception.ErrorCodes;
import com.mohamed.commerce.Exception.InvalidEntityException;
import com.mohamed.commerce.Repository.EntrepriseRepository;
import com.mohamed.commerce.Services.EntrepriseService;
import com.mohamed.commerce.dto.EntrepriseDto;
import com.mohamed.commerce.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;


    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;

    }

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors = EntrepriseValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Entreprise n'est pas valide");
            throw new InvalidEntityException("L'entreprise n'est pas valide", ErrorCodes.Entreprise_NOT_VALID,errors);
        }
        return EntrepriseDto.fromEntity((entrepriseRepository.save(EntrepriseDto.toEntity(dto))));

    }


    @Override
    public EntrepriseDto findById(Integer Entreprise_ID) {
        if (Entreprise_ID==null){
            log.error("L'id entreprise est null");
            return null;
        }
        return entrepriseRepository.findById(Entreprise_ID)
                .map(EntrepriseDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException(
                        "Aucune entreprise avec l'id ="+Entreprise_ID +" n'ete trouve pas dans BD"
                        ,ErrorCodes.Entreprise_NOT_FOUND)
                );
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect((Collectors.toList()));
    }

    @Override
    public void delete(Integer Entreprise_ID) {
    if (Entreprise_ID==null){
        log.error("L'id de l'entreprise est null");
    }
    entrepriseRepository.deleteById(Entreprise_ID);
    }
}
