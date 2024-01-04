package com.wi.quiz.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Response {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String response;

    @OneToMany(mappedBy = "response", cascade = CascadeType.ALL)
    List<Validation> validations;

    public Response(Long id) {
        this.id = id;
    }
}
