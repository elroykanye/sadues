package com.elroykanye.sadues.data.entity;

import com.elroykanye.sadues.data.entity.relation.DuesInfo;
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
import javax.persistence.OneToMany;
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
@Table(name = "sa_academic_year")
public class AcademicYear {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	@Column( nullable = false) private String name;

	@OneToMany(mappedBy = "academicYear", cascade = CascadeType.ALL, orphanRemoval = true)
	@ToString.Exclude
	private List<DuesInfo> duesInfos = new ArrayList<>();

}
