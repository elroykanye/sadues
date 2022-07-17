package com.elroykanye.sadues.data.entity.composite;

import javax.persistence.Column;
import java.io.Serial;
import java.io.Serializable;

public record DuesPaymentKey (
        @Column(name = "student_id") Long studentId,
        @Column(name = "year_id") Long academicYearId
) implements Serializable {
    @Serial
    private static final long serialVersionUID = -9151207802665273973L;
}
