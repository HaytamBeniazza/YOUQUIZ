package com.wi.quiz.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class AssignQuiz {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Quiz quiz;
    @OneToMany(mappedBy = "assignQuiz", cascade = CascadeType.ALL)
    private List<Answer> answers;
    private int score;
    private int chance;
    private String notes;
    private LocalDate date;
    @Setter
    @Getter
    private boolean played;
}
