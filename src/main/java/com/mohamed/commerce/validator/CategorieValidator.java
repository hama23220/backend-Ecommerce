package com.mohamed.commerce.validator;

import com.mohamed.commerce.dto.CategorieDto;

import java.util.ArrayList;
import java.util.List;

public class CategorieValidator {
    public static List<String> validator(CategorieDto dto){
        List<String> errors = new ArrayList<>();
    if ((dto==null)){
        errors.add("Veuillez renseigner libelle d'article");
        errors.add("Veuillez renseigner le nom  categorie");
        errors.add("Veuillez selectionner une categorie");
    }



    return errors;
    }

}
