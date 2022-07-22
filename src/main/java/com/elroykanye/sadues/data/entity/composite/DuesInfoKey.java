package com.elroykanye.sadues.data.entity.composite;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DuesInfoKey implements Serializable {
    private static final long serialVersionUID = 2554316551235785161L;
    @Column(name = "year_id") Long academicYearId;
    @Column(name = "assoc_id") Long associationId;
}
