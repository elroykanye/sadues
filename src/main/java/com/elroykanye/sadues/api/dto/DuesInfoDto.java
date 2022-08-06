package com.elroykanye.sadues.api.dto;

import java.io.Serializable;

public record DuesInfoDto(DuesInfoKeyDto key, Double amount) implements Serializable {
    public record DuesInfoKeyDto(Long academicYearId, Long associationId) implements Serializable {
    }
}
