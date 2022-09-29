package com.elroykanye.sadues.api.dto;

import com.elroykanye.sadues.data.enums.Position;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public record MembershipDto(
        @NotNull MembershipDto.MembershipKeyDto key,
        Position position,
        String joinedYear) implements Serializable {
    public record MembershipKeyDto(
            @NotNull Long userId,
            @NotNull Long associationId
    ) implements Serializable {
    }
}
