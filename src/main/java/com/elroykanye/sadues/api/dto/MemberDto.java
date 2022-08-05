package com.elroykanye.sadues.api.dto;

import com.elroykanye.sadues.data.enums.Position;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public record MemberDto(@NotNull MemberKeyDto key, Position position, String joinedYear) implements Serializable {
    public record MemberKeyDto(@NotNull Long userId, @NotNull Long associationId) implements Serializable {
    }
}
