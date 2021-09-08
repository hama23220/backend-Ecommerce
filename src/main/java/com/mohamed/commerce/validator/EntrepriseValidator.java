package com.mohamed.commerce.validator;

import com.mohamed.commerce.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
    public static List<String> validate(EntrepriseDto dto){
        List<String> errors = new ArrayList<>();
        if (dto==null){
            errors.add("Veuiller renseigner le nom d'entreprise");
            errors.add("Veuiller renseigner description du entreprise");
            errors.add("Veuiller renseigner l'adresse de l'entreprise");
            errors.add("Veuiller renseigner le code fiscale de l'entreprise");
            errors.add("Veuiller renseigner le photo  d'entreprise");
            errors.add("Veuiller renseigner l'email d'entreprise");
            errors.add("Veuiller renseigner le num telephone d'entreprise");
            errors.add("Veuiller renseigner le site web d'entreprise");
            return errors;
        }
        if ((!StringUtils.hasLength(dto.getNom()))){
            errors.add("Veuiller renseigner le nom d'entreprise");
        }
        if (!StringUtils.hasLength(dto.getDescription())){
            errors.add("Veuiller renseigner description du entreprise");
        }
        if (!StringUtils.hasLength(dto.getAdresse())){
            errors.add("Veuiller renseigner l'adresse de l'entreprise");
        }
        if (!StringUtils.hasLength(dto.getCodeFiscal())){
            errors.add("Veuiller renseigner le code fiscale de l'entreprise");
        }
        if (!StringUtils.hasLength(dto.getPhoto())){
            errors.add("Veuiller renseigner le photo  d'entreprise");
        }
        if (!StringUtils.hasLength(dto.getEmail())){
            errors.add("Veuiller renseigner l'email d'entreprise");
        }
        if (!StringUtils.hasLength(dto.getNumTel())){
            errors.add("Veuiller renseigner le num telephone d'entreprise");
        }
        if (!StringUtils.hasLength(dto.getSteWeb())){
            errors.add("Veuiller renseigner le site web d'entreprise");
        }
        return errors;
    }
}
