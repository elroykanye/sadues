package com.elroykanye.sadues.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "university")
public class University {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	@Column(nullable = false, unique = true) private String name;
	@Column private String location;
	@Column private Boolean approved;

	@OneToMany(mappedBy = "university", cascade = CascadeType.ALL, orphanRemoval = true)
	@ToString.Exclude
	private List<Association> associations = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "current_academic_year_id")
	private AcademicYear currentYear;

}
