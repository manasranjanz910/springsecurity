package dev.manas.jwtAuthentication3.service;

import dev.manas.jwtAuthentication3.dtos.UserRequestDto;
import dev.manas.jwtAuthentication3.dtos.UserResponseDto;
import dev.manas.jwtAuthentication3.models.User;
import dev.manas.jwtAuthentication3.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User savedUser = convertUserRequestDtoToUser(userRequestDto);
        savedUser = userRepository.save(savedUser);
        return convertUserToUserResponseDto(savedUser);
    }
    @Override
    public List<UserResponseDto> getAllUsers() {
        List<UserResponseDto> usersList = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User u : users)
        {
            usersList.add(convertUserToUserResponseDto(u));
        }
        return usersList;
    }

    UserResponseDto convertUserToUserResponseDto(User u )
    {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(u.getName());
        userResponseDto.setId(u.getId());
        return userResponseDto;
    }
    User convertUserRequestDtoToUser(UserRequestDto userRequestDto)
    {
        User u = new User();
        u.setName(userRequestDto.getName());
        u.setEmail(userRequestDto.getEmail());
        u.setPassword(userRequestDto.getPassword());
        return u;
    }

}
