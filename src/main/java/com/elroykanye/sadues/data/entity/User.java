package com.elroykanye.sadues.data.entity;

import com.elroykanye.sadues.data.entity.relation.Member;
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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(name = "name", nullable = false) private String name;
    @Column(name = "reg_no", unique = true, nullable = false) private String regNo;
    @Column(name = "password", nullable = false) private String password;
    @Column(name = "email") private String email;

    @Enumerated(EnumType.STRING) @Column(name = "gender", nullable = false) private Gender gender;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    @ToString.Exclude
    private Set<Member> members = new LinkedHashSet<>();

}
