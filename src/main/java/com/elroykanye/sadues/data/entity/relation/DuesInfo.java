package com.elroykanye.sadues.data.entity.relation;

import com.elroykanye.sadues.data.entity.AcademicYear;
import com.elroykanye.sadues.data.entity.Association;
import com.elroykanye.sadues.data.entity.composite.DuesInfoKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dues_info")
public class DuesInfo {
    @EmbeddedId private DuesInfoKey key;
    @Column(name = "amount", nullable = false) private Double amount;

    @MapsId("academicYearId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "academic_year_id", nullable = false)
    private AcademicYear academicYear;

    @MapsId("associationId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "association_id", nullable = false)
    private Association association;

}
