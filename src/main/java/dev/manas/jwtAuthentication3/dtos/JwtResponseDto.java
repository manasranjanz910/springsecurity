package dev.manas.jwtAuthentication3.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtResponseDto {
    private String jwtToken;
    private String username;
}
