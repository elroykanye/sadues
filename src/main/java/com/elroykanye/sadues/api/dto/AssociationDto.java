package com.elroykanye.sadues.api.dto;

import com.elroykanye.sadues.data.enums.AssociationType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public record AssociationDto(
        Long id,
        @NotNull String name, AssociationType type,
        @NotNull @Min(value = 1) Long universityId,
        Long headAssociationId, Long creatorId) implements Serializable {
}
