package com.mohamed.commerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mohamed.commerce.model.User;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private Integer id;
    private String nom;
    private String prenom;
    private String tel;
    private String email;
    private String adresse;

    private EntrepriseDto entreprise;

    private List<RoleUserDto> roles;

    @JsonIgnore
    private List<CommandeClientDto> commandeClients;


    public static  UserDto fromEntity(User user){
        if (user==null){
            return null;
        }
        return UserDto.builder()
                .id(user.getId())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .tel(user.getTel())
                .email(user.getEmail())
                .adresse(user.getAdresse())
//                .entreprise(EntrepriseDto.fromEntity(user.getEntreprise()))
//                .roles(
//                        user.getRoles()!=null?
//                                user.getRoles().stream()
//                                .map(RoleUserDto::fromEntity)
//                                .collect(Collectors.toList()):null
//                )
                .build();
    }
    public static User toEntity(UserDto userDto){
        if (userDto== null){
            return null;
        }
        User user =new User();
        user.setId(userDto.getId());
        user.setNom(user.getNom());
        user.setPrenom(user.getPrenom());
        user.setTel(user.getTel());
        user.setEmail(user.getEmail());
        user.setAdresse(user.getAdresse());
//        user.setEntreprise(EntrepriseDto.toEntity(userDto.getEntreprise()));
        return user;
    }
}
