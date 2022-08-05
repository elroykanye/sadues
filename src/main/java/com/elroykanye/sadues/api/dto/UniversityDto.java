package com.elroykanye.sadues.api.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public record UniversityDto(
        Long id,
        @NotNull String name, @NotNull String location, @NotNull Boolean approved, Long currentYearId) implements Serializable {
}
