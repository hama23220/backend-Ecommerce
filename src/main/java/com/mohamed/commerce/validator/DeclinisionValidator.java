package com.mohamed.commerce.validator;

import com.mohamed.commerce.dto.DeclinisionDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DeclinisionValidator {

    public static List<String> validate(DeclinisionDto dto){
        List<String> errors = new ArrayList<>();
        if (dto==null){
            errors.add("Veuillez renseigner le couleur d'article");
            errors.add("Veuillez renseigner le taille d'article");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getCouleur())){
            errors.add("Veuillez renseigner le couleur d'article");
        }
        if (dto.getTaille()==null){
            errors.add("Veuillez renseigner le taille d'article");
        }
        return errors;
    }
}
