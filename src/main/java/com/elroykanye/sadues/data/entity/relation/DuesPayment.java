package com.elroykanye.sadues.data.entity.relation;

import com.elroykanye.sadues.data.entity.AcademicYear;
import com.elroykanye.sadues.data.entity.Student;
import com.elroykanye.sadues.data.entity.composite.DuesPaymentKey;
import com.elroykanye.sadues.data.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dues_payment")
public class DuesPayment {
     @EmbeddedId private DuesPaymentKey key;
     @Column(name = "amount", nullable = false) private Double amount;
     @Column(name = "date", nullable = false) private Date date;
     @Enumerated @Column(name = "status", nullable = false) private PaymentStatus status;

     @MapsId("studentId")
     @ManyToOne(optional = false)
     @JoinColumn(name = "student_id", nullable = false)
     private Student student;

     @MapsId("academicYearId")
     @ManyToOne(optional = false)
     @JoinColumn(name = "academic_year_id", nullable = false)
     private AcademicYear academicYear;

}
