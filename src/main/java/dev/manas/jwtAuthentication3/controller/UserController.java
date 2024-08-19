package dev.manas.jwtAuthentication3.controller;

import dev.manas.jwtAuthentication3.dtos.UserRequestDto;
import dev.manas.jwtAuthentication3.dtos.UserResponseDto;
import dev.manas.jwtAuthentication3.models.User;
import dev.manas.jwtAuthentication3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto)
    {
        return ResponseEntity.ok(userService.createUser(userRequestDto));
    }
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers()
    {
        return ResponseEntity.ok(userService.getAllUsers());
    }

}
