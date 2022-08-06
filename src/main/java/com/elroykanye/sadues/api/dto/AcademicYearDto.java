package com.elroykanye.sadues.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public record AcademicYearDto(
        Long id,
        @NotNull @NotEmpty String name) implements Serializable {
}
