package com.elroykanye.sadues.data.entity.composite;

import javax.persistence.Column;
import java.io.Serial;
import java.io.Serializable;

public record DuesInfoKey (
        @Column(name = "year_id") Long academicYearId,
        @Column(name = "assoc_id") Long associationId
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 3690343896326723255L;
}
