package com.elroykanye.sadues.api.dto;

import com.elroykanye.sadues.data.enums.Position;

import java.io.Serializable;

public record MemberDto(MemberKeyDto key, Position position, Long academicYearId) implements Serializable {
    public record MemberKeyDto(Long userId, Long associationId) implements Serializable {
    }
}
