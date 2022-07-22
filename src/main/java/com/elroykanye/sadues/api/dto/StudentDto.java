package com.elroykanye.sadues.api.dto;

import com.elroykanye.sadues.data.enums.Gender;

import java.io.Serializable;

public record StudentDto(Long id, String name, String regNo, String password, Gender gender) implements Serializable {
}
