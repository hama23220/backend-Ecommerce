package com.mohamed.commerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mohamed.commerce.model.RoleUser;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleUserDto {
    private Long id;
    private String roleName;

    @JsonIgnore
    private UserDto user;


    public static RoleUserDto fromEntity(RoleUser roleUser){
        if (roleUser== null){
            return null;
        }
        return RoleUserDto.builder()
                .id(roleUser.getId())
                .roleName(roleUser.getRoleName())

                .build();
    }
    public static RoleUser  toEntity(RoleUserDto Dto){
        if(Dto== null){
            return null;
        }
        RoleUser roles = new RoleUser();
        roles.setId(Dto.getId());
        roles.setRoleName(Dto.getRoleName());
        roles.setUser(UserDto.toEntity(Dto.getUser()));
        return roles;
    }
}
