package com.mitocode.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // comparacion de contenido de objeto

public class Medic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idMedic;
	
	@ManyToOne()//FK
	@JoinColumn(name="id_specialty",nullable = false, foreignKey =@ForeignKey(name="FK_MEDIC_SPECIALTY"))
	private Specialty specialty;
	@Column(nullable = false, length = 70)
	private String firstName;
	@Column(nullable = false, length = 70)
	private String lastName;
	@Column(nullable = false, length = 12)
	private String cmp;
	@Column( length = 250)
	private String photoUrl;
}
