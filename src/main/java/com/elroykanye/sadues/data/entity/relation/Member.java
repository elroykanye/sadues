package com.elroykanye.sadues.data.entity;

import com.elroykanye.sadues.data.entity.relation.DuesPayment;
import com.elroykanye.sadues.data.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Member {
	@Id @GeneratedValue private Long id;
	@Column(name = "name", nullable = false) private String name;
	@Column(name = "reg_no", unique = true, nullable = false) private String regNo;
	@Column(name = "password", nullable = false) private String password;
	@Column(name = "position", nullable = false) private String position;
	@Enumerated(EnumType.STRING) @Column(name = "gender", nullable = false) private Gender gender;

	@OneToMany(mappedBy = "member", orphanRemoval = true)
	private List<DuesPayment> duesPayments = new ArrayList<>();

	@ManyToMany(mappedBy = "members")
	private Set<Association> associations = new LinkedHashSet<>();

}
