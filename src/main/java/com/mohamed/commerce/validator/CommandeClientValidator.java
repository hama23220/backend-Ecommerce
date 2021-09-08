package com.mohamed.commerce.validator;

import com.mohamed.commerce.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {
public static List<String> validator(CommandeClientDto dto){
    List<String> errors = new ArrayList<>();
    if (dto==null){
        errors.add("Veuillez renseigner le code de la commande");
        errors.add("Veuillez renseigner la libelle de la commande");
        errors.add("Veuillez renseigner le totale de la commande");
        errors.add("Veuillez renseigner la date de la commande");
        errors.add("Veuillez renseigner le client");
        return errors;
    }
    if (!StringUtils.hasLength(dto.getCodeCommande())){
        errors.add("Veuillez renseigner le code de la commande");
    }
    if (!StringUtils.hasLength(dto.getLibelle())){
        errors.add("Veuillez renseigner la libelle de la commande");
    }
    if (dto.getTotale()==null){
        errors.add("Veuillez renseigner le totale de la commande");
    }
    if (!StringUtils.hasLength(dto.getDate().toString())){
        errors.add("Veuillez renseigner la date de la commande");
    }
    if (dto.getUser()==null||dto.getUser().getId()==null){
        errors.add("Veuillez renseigner le client");
    }
    return errors;
}
}
