package com.elroykanye.sadues.api.dto;

import com.elroykanye.sadues.data.enums.PaymentStatus;

import java.io.Serializable;
import java.sql.Date;

public record DuesPaymentDto(
        Long id,
        Double amount,
        Date date,
        PaymentStatus status,
        MemberDto.MemberKeyDto memberKey
) implements Serializable { }
