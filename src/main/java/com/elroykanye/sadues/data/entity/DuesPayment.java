package com.elroykanye.sadues.data.entity;

import com.elroykanye.sadues.data.entity.relation.Membership;
import com.elroykanye.sadues.data.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dues_payment")
public class DuesPayment {
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
     @Column(nullable = false) private Double amount;
     @Column(nullable = false) private Date date;
     @Enumerated @Column(nullable = false) private PaymentStatus status;

     @ManyToOne(optional = false)
     @JoinColumns({
             @JoinColumn(name = "MEMBER_USER_ID", referencedColumnName = "USER_ID", nullable = false),
             @JoinColumn(name = "MEMBER_ASSOCIATION_ID", referencedColumnName = "ASSOCIATION_ID", nullable = false)
     })
     private Membership membership;

}
