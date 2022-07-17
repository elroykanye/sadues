package com.elroykanye.sadues.api.dto;

import java.io.Serializable;

public record ExecutiveDto(Long id, String name, String position, Long associationId) implements Serializable {
}
