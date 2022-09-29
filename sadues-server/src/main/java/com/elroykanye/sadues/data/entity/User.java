package com.elroykanye.sadues.data.entity;

import com.elroykanye.sadues.data.entity.relation.Membership;
import com.elroykanye.sadues.data.enums.Gender;
import com.elroykanye.sadues.data.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sa_user")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(unique = true, nullable = false) private String email;
    @Column(unique = true, nullable = false) private String regNo;
    @Column(nullable = false) private String name;
    @Column(nullable = false) private String password;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private Role role;

    @Enumerated(EnumType.STRING) @Column(nullable = false) private Gender gender;

    @OneToMany(mappedBy = "user", orphanRemoval = true) @ToString.Exclude
    private Set<Membership> memberships = new LinkedHashSet<>();

    @ManyToOne()
    @JoinColumn(name = "university_id")
    private University university;

    @OneToMany(mappedBy = "creator", orphanRemoval = true)
    @ToString.Exclude
    private Set<Association> associations = new LinkedHashSet<>();

}
