package com.mohamed.commerce.Services.Impl;

import com.mohamed.commerce.Exception.EntityNotFoundException;
import com.mohamed.commerce.Exception.ErrorCodes;
import com.mohamed.commerce.Exception.InvalidEntityException;
import com.mohamed.commerce.Repository.DeclinisionRepository;
import com.mohamed.commerce.Services.DeclinisionService;
import com.mohamed.commerce.dto.DeclinisionDto;
import com.mohamed.commerce.validator.DeclinisionValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DeclinisionServiceImpl implements DeclinisionService {

    private DeclinisionRepository declinisionRepository;

    @Autowired
    public DeclinisionServiceImpl(DeclinisionRepository declinisionRepository) {
        this.declinisionRepository = declinisionRepository;
    }

    @Override
    public DeclinisionDto save(DeclinisionDto dto) {
        List<String> error= DeclinisionValidator.validate(dto);
        if (!error.isEmpty()){
            log.error("Declinision n'est pas valid {]",dto);
            throw new InvalidEntityException("Declinision n'est pas valid", ErrorCodes.Declinision_NOT_VALID,error);
        }
        return DeclinisionDto.fromEntity(
                declinisionRepository.save(DeclinisionDto.toEntity(dto)
        ));
    }

    @Override
    public DeclinisionDto findById(Integer Declinision_ID) {
    if (Declinision_ID==null){
        log.error("ID declinision est null");
        return null;
    }
    return declinisionRepository.findById(Declinision_ID)
            .map(DeclinisionDto::fromEntity)
            .orElseThrow(()->
                    new EntityNotFoundException(
                            "Aucune declinision avec l'id"+Declinision_ID+"n'ete trouve dans la BD",
                            ErrorCodes.Declinision_NOT_FOUND
                    ));
    }

    @Override
    public DeclinisionDto findByCouleur(String couleur) {
    if (!StringUtils.hasLength(couleur)){
        log.error("Couleur declinision est null");
        return null;
    }
    return declinisionRepository.findByCouleur(couleur)
            .map(DeclinisionDto::fromEntity)
            .orElseThrow(()-> new EntityNotFoundException("Aucune declinision avec le couleur ="
                            +couleur+"n'ete trouve dans la BD ",ErrorCodes.Declinision_NOT_FOUND)
                    );

    }

    @Override
    public DeclinisionDto findByTaille(String taille) {
        if (!StringUtils.hasLength(taille)){
            log.error("Taille declinision est null");
            return  null;
        }
        return declinisionRepository.findByTaille(taille)
                .map(DeclinisionDto::fromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException(
                                "Aucune declinision avec la taille ="+taille+"n'ete trouve dans la BD",
                                ErrorCodes.Declinision_NOT_FOUND
                        ));
    }

    @Override
    public List<DeclinisionDto> findAll() {
    return declinisionRepository.findAll().stream()
            .map(DeclinisionDto::fromEntity)
            .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer Declinision_ID) {
        if (Declinision_ID==null){
            log.error("Id declinision est null");
        }
        declinisionRepository.deleteById(Declinision_ID);

    }
}
