package com.mitocode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@Table(name = "tbl_patient", schema = "sistemas")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPatient;

    @Column(nullable = false, length = 70) //, name = "primer_nombre"
    private String firstName; //camelCase | lowerCamelCase | UpperCamelCase | BD: snake first_name

    @Column(nullable = false, length = 70)
    private String lastName;

    @Column(nullable = false, length = 8)
    private String dni;

    @Column(length = 150)
    private String address;

    @Column(nullable = false, length = 9)
    private String phone;

    @Column(nullable = false, length = 55)
    private String email;

}
