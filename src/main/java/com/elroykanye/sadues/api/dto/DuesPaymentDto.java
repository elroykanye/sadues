package com.elroykanye.sadues.api.dto;

import com.elroykanye.sadues.data.enums.PaymentStatus;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public record DuesPaymentDto(
        Long id,
        @NotNull @Min(value = 100) Double amount,
        Date date,
        PaymentStatus status,
        @NotNull Long associationId,
        @NotNull MembershipDto.MemberKeyDto memberKey
) implements Serializable { }
