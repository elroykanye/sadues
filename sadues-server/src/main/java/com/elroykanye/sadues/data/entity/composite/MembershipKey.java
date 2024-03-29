package com.elroykanye.sadues.data.entity.composite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class MembershipKey implements Serializable {
    @Serial private static final long serialVersionUID = -217769896022933114L;
    @Column @Getter Long userId;
    @Column @Getter Long associationId;
}
