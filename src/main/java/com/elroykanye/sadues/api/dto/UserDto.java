package com.elroykanye.sadues.api.dto;

import com.elroykanye.sadues.data.enums.Gender;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public record UserDto(
        Long id, @NotEmpty String name, @NotEmpty String regNo, @NotEmpty String password, @NotEmpty @Email String email,
        Gender gender) implements Serializable {
}
