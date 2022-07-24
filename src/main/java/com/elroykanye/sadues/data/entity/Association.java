package com.elroykanye.sadues.data.entity;

import com.elroykanye.sadues.data.entity.relation.DuesInfo;
import com.elroykanye.sadues.data.entity.relation.Member;
import com.elroykanye.sadues.data.enums.AssociationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "association")
public class Association {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	@Column(name = "name", nullable = false) private String name;
	@Enumerated @Column(name = "type", nullable = false) private AssociationType type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    @OneToMany(mappedBy = "association", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<DuesInfo> duesInfos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "head_association_id")
    private Association headAssociation;

    @OneToMany(mappedBy = "association", orphanRemoval = true)
    @ToString.Exclude
    private Set<Member> members = new LinkedHashSet<>();

}
