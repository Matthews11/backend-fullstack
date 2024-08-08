package com.mitocode.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPatient;
	
	@Column(nullable = false, length = 70)
	private String fistName;
	@Column(nullable = false, length = 70)
	private String lastName;
	@Column(nullable = false, length = 8)
	private String dni;
	@Column( length = 150)
	private String address;
	@Column(nullable = false, length = 9)
	private String phone;
	@Column(nullable = false, length = 55)
	private String email;
	
}
