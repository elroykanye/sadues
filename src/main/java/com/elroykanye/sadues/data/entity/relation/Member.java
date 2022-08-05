package com.elroykanye.sadues.data.entity.relation;

import com.elroykanye.sadues.data.entity.AcademicYear;
import com.elroykanye.sadues.data.entity.Association;
import com.elroykanye.sadues.data.entity.User;
import com.elroykanye.sadues.data.entity.composite.MemberKey;
import com.elroykanye.sadues.data.entity.DuesPayment;
import com.elroykanye.sadues.data.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class Member {
	@EmbeddedId private MemberKey key;

	@Enumerated(EnumType.STRING) @Column(name = "position", nullable = false) private Position position;

	@ManyToOne(optional = false) @JoinColumn(name = "academic_year_id", nullable = false) private AcademicYear academicYear;

	@OneToMany(mappedBy = "member", orphanRemoval = true) private List<DuesPayment> duesPayments = new ArrayList<>();

	@MapsId("userId")
	@ManyToOne(optional = false) @JoinColumn(name = "user_id", nullable = false) private User user;

	@MapsId("associationId")
	@ManyToOne(optional = false) @JoinColumn(name = "association_id", nullable = false) private Association association;
}