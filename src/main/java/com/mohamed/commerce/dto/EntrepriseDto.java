package com.mohamed.commerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mohamed.commerce.model.Entreprise;
import com.mohamed.commerce.model.User;
import lombok.*;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EntrepriseDto {
    private Integer id;
    private String nom;
    private String description;
    private String adresse;
    private String codeFiscal;
    private String photo;
    private String email;
    private String numTel;
    private String steWeb;

    @JsonIgnore
    private List<User> users;


    public static EntrepriseDto fromEntity(Entreprise entreprise) {
        if (entreprise == null) {
            return null;
        }
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .codeFiscal(entreprise.getAdresse())
                .adresse(entreprise.getCodeFiscal())
                .photo(entreprise.getPhoto())
                .email(entreprise.getEmail())
                .numTel(entreprise.getNumTel())
                .steWeb(entreprise.getSteWeb())
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto dto) {
        if (dto == null) {
            return null;
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setId(dto.getId());
        entreprise.setNom(dto.getNom());
        entreprise.setDescription(dto.getDescription());
        entreprise.setAdresse(dto.getAdresse());
        entreprise.setCodeFiscal(dto.getCodeFiscal());
        entreprise.setPhoto(dto.getPhoto());
        entreprise.setEmail(dto.getEmail());
        entreprise.setNumTel(dto.getNumTel());
        entreprise.setSteWeb(dto.getSteWeb());

        return entreprise;
    }
}
