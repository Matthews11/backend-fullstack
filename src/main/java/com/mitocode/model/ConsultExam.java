package com.mitocode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(ConsultExamPk.class)
public class ConsultExam {

    @Id
    private Consult consult;

    @Id
    private Exam exam;

}
