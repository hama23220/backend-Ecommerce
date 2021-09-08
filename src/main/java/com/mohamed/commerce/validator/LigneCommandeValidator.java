package com.mohamed.commerce.validator;

import com.mohamed.commerce.dto.LignecommandeDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeValidator {
    public static List<String> validate(LignecommandeDto dto){
        List<String> errors= new ArrayList<>();
        if (dto== null){
            errors.add("Veuillez renseigner le prix unitaire de l'article");
            errors.add("Veuillez renseigner la quantite  d'article");
            errors.add("Veuillez selectionner un commande client");
            errors.add("Veuillez selectionner un article");
            return errors;
        }
        if (dto.getPrixUnitaire()==null){
            errors.add("Veuillez renseigner le prix unitaire de l'article");
        }
        if (dto.getQte()==null){
            errors.add("Veuillez renseigner la quantite  d'article");
        }
        if (dto.getCommandeClient()==null||dto.getCommandeClient().getId()==null){
            errors.add("Veuillez selectionner un commande client");
        }
        if (dto.getArticle()==null||dto.getArticle().getId()==null){
            errors.add("Veuillez selectionner un article");
        }
        return errors;
    }
}
