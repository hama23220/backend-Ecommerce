package com.mohamed.commerce.validator;

import com.mohamed.commerce.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {
    public static List<String> validate(UserDto dto){
        List<String> errors = new ArrayList<>();
        if( dto==null){
            errors.add("Veuillez renseigner le nom d'utilisateur");
            errors.add("Veuillez renseigner le prenom d'utilisateur");
            errors.add("Veuillez renseigner le telephonne  d'utilisateur");
            errors.add("Veuillez renseigner l'email d'utilisateur");
            errors.add("Veuillez renseigner l'adresse d'utilisateur");
        }
        if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez renseigner le nom d'utilisateur");
        }
        if (!StringUtils.hasLength(dto.getPrenom())){
            errors.add("Veuillez renseigner le prenom d'utilisateur");
        }
        if (!StringUtils.hasLength(dto.getTel())){
            errors.add("Veuillez renseigner le telephonne  d'utilisateur");
        }
        if (!StringUtils.hasLength(dto.getEmail())){
            errors.add("Veuillez renseigner l'email d'utilisateur");
        }
        if (!StringUtils.hasLength(dto.getAdresse())){
            errors.add("Veuillez renseigner l'adresse d'utilisateur");
        }
        return errors;
    }
}
