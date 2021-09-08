package com.mohamed.commerce.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChangePasswordUserDto {

    private Integer id;

    private String password;

    private String validatePassword;
}
