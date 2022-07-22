package com.elroykanye.sadues.data.entity.composite;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DuesPaymentKey implements Serializable {
    private static final long serialVersionUID = 2839461174875603557L;
    @Column(name = "student_id") Long studentId;
    @Column(name = "year_id") Long academicYearId;
}
