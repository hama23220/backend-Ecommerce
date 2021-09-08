package com.mohamed.commerce.Controller;

import com.mohamed.commerce.Controller.Api.UserApi;
import com.mohamed.commerce.Services.UserService;
import com.mohamed.commerce.dto.ChangePasswordUserDto;
import com.mohamed.commerce.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControlleur implements UserApi {

    private UserService userService ;

    @Autowired
    public UserControlleur(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto save(UserDto dto) {
        return userService.save(dto);
    }

    @Override
    public UserDto findById(Integer User_ID) {
        return userService.findById(User_ID);
    }

    @Override
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @Override
    public void delete(Integer User_ID) {
    userService.delete(User_ID);
    }

    @Override
    public UserDto findByEmail(String email) {
      return    userService.findByEmail(email);
    }

    @Override
    public UserDto changerPassword(ChangePasswordUserDto dto) {
        return null;
    }
}
