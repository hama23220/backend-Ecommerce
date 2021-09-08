package com.mohamed.commerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mohamed.commerce.model.Article;
import com.mohamed.commerce.model.Categorie;
import lombok.*;

import java.util.List;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategorieDto {
    private Integer id;
    private String name;
    private Categorie parent;


    @JsonIgnore
    private List<Article> articles;

    public static CategorieDto fromEntity(Categorie categorie){
        if (categorie == null){
            return  null;
        }

        return CategorieDto.builder()
                .id(categorie.getId())
                .name(categorie.getName())
                .parent(categorie.getParent())
                .build();
    }
    public static  Categorie toEntity(CategorieDto categorieDto){
        if ((categorieDto == null)) {
            return  null;
        }
        Categorie categorie = new Categorie();
        categorie.setId(categorieDto.getId());
        categorie.setName(categorieDto.getName());
        categorie.setParent(categorieDto.getParent());
        return categorie;
    }

}
