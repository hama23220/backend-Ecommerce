package com.mohamed.commerce.validator;

import com.mohamed.commerce.dto.RoleUserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RoleUserValidator {
    public static List<String> validate(RoleUserDto dto){
        List<String> errors= new ArrayList<>();
        if(dto==null){
            errors.add("Veuillez renseigner le role d'utilisateur");
            return errors;
        }
        if(!StringUtils.hasLength(dto.getRoleName())){
            errors.add("Veuillez renseigner le role d'utilisateur");
        }
        return errors;
    }
}
