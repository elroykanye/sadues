package com.elroykanye.sadues.data.entity;

import com.elroykanye.sadues.data.entity.relation.DuesInfo;
import com.elroykanye.sadues.data.entity.relation.Membership;
import com.elroykanye.sadues.data.enums.AssociationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sa_association")
public class Association {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	@Column(nullable = false, unique = true) private String name;
	@Enumerated(EnumType.STRING) @Column(nullable = false) private AssociationType type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    @OneToMany(mappedBy = "association", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude @Builder.Default
    private List<DuesInfo> duesInfos = new ArrayList<>();

    @OneToMany(mappedBy = "association", orphanRemoval = true)
    @ToString.Exclude @Builder.Default
    private Set<Membership> memberships = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "head_association_id")
    private Association headAssociation;

    @OneToMany(mappedBy = "headAssociation", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude @Builder.Default
    private List<Association> subAssociations = new ArrayList<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;
}
