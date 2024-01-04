package com.wi.quiz.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String description;
    private int maxPoints;
    private int minPoints;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    private List<Question> questions;


    public Level(Long id) {
        this.id = id;
    }
}
