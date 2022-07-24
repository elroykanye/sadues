package com.elroykanye.sadues.api.dto;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public record UniversityDto(
        Long id,
        @NotNull String name, String location, Boolean approved) implements Serializable {
}
