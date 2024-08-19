package dev.manas.jwtAuthentication3.service;


import dev.manas.jwtAuthentication3.dtos.UserRequestDto;
import dev.manas.jwtAuthentication3.dtos.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);
    List<UserResponseDto> getAllUsers();


}
