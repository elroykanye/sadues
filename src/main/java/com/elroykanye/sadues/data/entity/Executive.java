package com.elroykanye.sadues.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "executive")
public class Executive {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	@Column(name = "name", nullable = false) private String name;
	@Column(name = "position", nullable = false) private String position;

    @ManyToOne(optional = false)
    @JoinColumn(name = "association_id", nullable = false)
    private Association association;

    @PrePersist
	public void prePersist() {
		if (this.position == null || this.position.equals("")) {
			this.position = "Executive";
		}
	}
}
