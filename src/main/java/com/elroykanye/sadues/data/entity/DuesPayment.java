package com.elroykanye.sadues.data.entity;

import com.elroykanye.sadues.data.entity.relation.Member;
import com.elroykanye.sadues.data.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
     @Id @GeneratedValue private Long id;
     @Column(name = "amount", nullable = false) private Double amount;
     @Column(name = "date", nullable = false) private Date date;
     @Enumerated @Column(name = "status", nullable = false) private PaymentStatus status;


     @ManyToOne(optional = false)
     @JoinColumns({
             @JoinColumn(name = "MEMBER_USER_ID", referencedColumnName = "USER_ID", nullable = false),
             @JoinColumn(name = "MEMBER_ASSOCIATION_ID", referencedColumnName = "ASSOCIATION_ID", nullable = false)
     })
     private Member member;

}