package com.elroykanye.sadues.api.dto;

import com.elroykanye.sadues.data.enums.AssociationType;

import java.io.Serializable;

public record AssociationDto(Long id, String name, AssociationType type, Long universityId) implements Serializable {
}
