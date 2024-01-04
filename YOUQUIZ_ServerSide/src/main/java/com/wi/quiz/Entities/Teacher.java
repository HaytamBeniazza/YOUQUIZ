package com.wi.quiz.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher extends Person{
    private String speciality;
    @OneToMany(mappedBy = "teacher" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Quiz> quizzes;
}
