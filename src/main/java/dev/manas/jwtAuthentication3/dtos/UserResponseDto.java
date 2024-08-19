package dev.manas.jwtAuthentication3.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserResponseDto {
    private long id;
    private String name;

}
