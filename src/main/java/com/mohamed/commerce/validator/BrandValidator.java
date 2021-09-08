package com.mohamed.commerce.validator;

import com.mohamed.commerce.dto.BrandDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class BrandValidator {

    public static List<String> validate(BrandDto dto){
        List<String> errors = new ArrayList<>();
        if (dto==null){
            errors.add("Veuillez renseigner marque d'article");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getMarque())){
            errors.add("Veuillez renseigner marque d'article");
        }
        return errors;
    }
}
