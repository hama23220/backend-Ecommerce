package com.mohamed.commerce.Services;

import com.mohamed.commerce.dto.ChangePasswordUserDto;
import com.mohamed.commerce.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto dto);

    UserDto findById(Integer User_ID);

    List<UserDto> findAll();

    void delete(Integer User_ID);

    UserDto findByEmail(String email);

    UserDto changerPassword(ChangePasswordUserDto dto);
}
