package com.mohamed.commerce.Controller.Api;

import com.mohamed.commerce.dto.ChangePasswordUserDto;
import com.mohamed.commerce.dto.UserDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mohamed.commerce.Utils.Constants.UTILISATEUR_ENDPOINT;

@Api("utilisateurs")
public interface UserApi {

    @PostMapping(UTILISATEUR_ENDPOINT + "/create")
    UserDto save(@RequestBody  UserDto dto);

    @GetMapping(UTILISATEUR_ENDPOINT + "/{User_ID}")
    UserDto findById(@PathVariable("User_ID") Integer User_ID);

    @GetMapping(UTILISATEUR_ENDPOINT + "/all")
    List<UserDto> findAll();

    @DeleteMapping(UTILISATEUR_ENDPOINT + "/delete/{User_ID}")
    void delete(@PathVariable("User_ID")Integer User_ID);

    @GetMapping(UTILISATEUR_ENDPOINT + "/find/{email}")
    UserDto findByEmail(@PathVariable("email") String email);

    @PostMapping(UTILISATEUR_ENDPOINT + "/update/password")
    UserDto changerPassword(@RequestBody ChangePasswordUserDto dto);
}
