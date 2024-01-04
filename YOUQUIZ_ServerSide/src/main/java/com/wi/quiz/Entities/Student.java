package com.wi.quiz.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student extends Person {
    private LocalDate enrollmentDate;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<AssignQuiz> quizzes;

    public Student(Long id) {
        super(id);
    }
}
