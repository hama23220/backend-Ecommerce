package com.mohamed.commerce.Services.Impl;

import com.mohamed.commerce.Exception.EntityNotFoundException;
import com.mohamed.commerce.Exception.ErrorCodes;
import com.mohamed.commerce.Exception.InvalidEntityException;
import com.mohamed.commerce.Repository.UserRepository;
import com.mohamed.commerce.Services.UserService;
import com.mohamed.commerce.dto.ChangePasswordUserDto;
import com.mohamed.commerce.dto.UserDto;
import com.mohamed.commerce.model.User;
import com.mohamed.commerce.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(UserDto dto) {
    List<String> errors = UserValidator.validate(dto);

        if (errors.isEmpty()) {
            log.error("utilisateur n'est pas valide {}",dto);
            throw new InvalidEntityException("L'utlisateur n'est pas valide", ErrorCodes.User_NOT_VALID,errors);
        }


        if (!userAlredyExists(dto.getEmail())){
            throw new InvalidEntityException("un autre utlisateur avec le meme email existe deja",ErrorCodes.USER_ALREADY_EXISTS,

                    Collections.singletonList("un autre utilisateur avec le meme email existe deja dans la BD"));
        }


        //il manque codage password
        return  UserDto.fromEntity(
                userRepository.save(UserDto.toEntity(dto))
        );
    }

    @Override
    public UserDto findById(Integer User_ID) {
        if (User_ID==null){
            log.error("L'id utilisateur est null ");
            return null;
        }
        return userRepository.findById(User_ID)
                .map(UserDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException(
                        "Aucun utilisateur avec L'id=  "+User_ID+" n'ete trouve dans la BD",
                        ErrorCodes.User_NOT_FOUND
                ));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserDto::fromEntity)
              .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer User_ID) {
        if (User_ID==null){
            log.error("L'id utlisateur est null");
        }
        userRepository.deleteById(User_ID);

    }

    @Override
    public UserDto findByEmail(String email) {
        return userRepository.findUserByEmail(email)
                .map(UserDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException(
                        "Aucun utilisateur avec l'email ="+email+" n'ete trouve dans la BD",
                        ErrorCodes.User_NOT_FOUND
                ));
    }

    @Override
    public UserDto changerPassword(ChangePasswordUserDto dto) {
        return null;

    }
    private Boolean userAlredyExists(String email){
        Optional<User> user = userRepository.findUserByEmail(email);
        return user.isPresent();
    }
}
