package com.mohamed.commerce.dto;

import com.mohamed.commerce.model.Declinision;
import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeclinisionDto {
    private Integer id;
    private String couleur;
    private String taille;

    public static  DeclinisionDto fromEntity(Declinision declinision){
        if (declinision==null){
            return null;
        }
        return DeclinisionDto.builder()
                .id(declinision.getId())
                .couleur(declinision.getCouleur())
                .taille(declinision.getTaille())
                .build();
    }
    public static  Declinision toEntity(DeclinisionDto declinisionDto){
        if(declinisionDto==null){
            return null;
        }
        Declinision declinision =new Declinision();
        declinision.setId(declinisionDto.getId());
        declinision.setCouleur(declinisionDto.getCouleur());
        declinision.setTaille(declinisionDto.getTaille());
        return  declinision;
    }
}
