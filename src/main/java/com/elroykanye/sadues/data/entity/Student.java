package com.elroykanye.sadues.data.entity;

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
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
	@Id @GeneratedValue private Long id;
	@Column(name = "name", nullable = false) private String name;
	@Column(name = "reg_no", unique = true, nullable = false) private String regNo;
	@Column(name = "password", nullable = false) private String password;
	@Enumerated(EnumType.STRING) @Column(name = "gender", nullable = false) private Gender gender;
}
