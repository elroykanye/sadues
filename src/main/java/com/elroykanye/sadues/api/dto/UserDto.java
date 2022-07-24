package com.elroykanye.sadues.api.dto;

import com.elroykanye.sadues.data.enums.Gender;

import java.io.Serializable;

public record UserDto(Long id, String name, String regNo, String password, String email,
                      Gender gender) implements Serializable {
}
