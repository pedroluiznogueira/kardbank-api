package com.github.pedroluiznogueira.kardbankapi.domain.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserDto {

    private String cpf;
    private String name;
    private String email;
}
