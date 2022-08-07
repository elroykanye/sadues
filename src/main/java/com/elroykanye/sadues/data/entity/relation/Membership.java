package com.elroykanye.sadues.data.entity.relation;

import com.elroykanye.sadues.data.entity.Association;
import com.elroykanye.sadues.data.entity.User;
import com.elroykanye.sadues.data.entity.composite.MembershipKey;
import com.elroykanye.sadues.data.entity.DuesPayment;
import com.elroykanye.sadues.data.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Table()
public class Membership {
	@EmbeddedId private MembershipKey key;
	@Column(name = "joined_year", nullable = false) private String joinedYear;
	@Enumerated(EnumType.STRING) @Column(name = "position", nullable = false) private Position position;
	
	@OneToMany(mappedBy = "membership", orphanRemoval = true)
	@ToString.Exclude
	private List<DuesPayment> duesPayments = new ArrayList<>();

	@MapsId("userId")
	@ManyToOne(optional = false) @JoinColumn(name = "user_id", nullable = false) private User user;

	@MapsId("associationId")
	@ManyToOne(optional = false) @JoinColumn(name = "association_id", nullable = false) private Association association;
}
