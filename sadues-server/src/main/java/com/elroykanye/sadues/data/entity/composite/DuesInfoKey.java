package com.elroykanye.sadues.data.entity.composite;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class DuesInfoKey implements Serializable {
    @Serial
    private static final long serialVersionUID = 2554316551235785161L;
    @Column @Getter Long academicYearId;
    @Column @Getter Long associationId;

    public DuesInfoKey(long academicYearId, long associationId) {
        this.academicYearId = academicYearId;
        this.associationId = associationId;
    }
}
