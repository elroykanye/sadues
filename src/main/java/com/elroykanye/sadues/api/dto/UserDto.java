package com.elroykanye.sadues.api.dto;

import com.elroykanye.sadues.data.enums.Gender;
import com.elroykanye.sadues.data.enums.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public record UserDto(
        Long id,
        @NotEmpty @Email String email,
        @NotEmpty String regNo,
        @NotEmpty String name, Role role,
        Gender gender) implements Serializable {

    public record UserLogin(@NotEmpty @Email String email, @NotEmpty String password) implements Serializable {
    }

    public record UserRegister(
            @NotEmpty @Email String email,
            @NotEmpty  String password,
            UserDto user
    ) implements Serializable {}
}
