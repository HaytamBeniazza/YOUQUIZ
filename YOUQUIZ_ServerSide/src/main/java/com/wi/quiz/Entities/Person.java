package com.wi.quiz.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Super;

import java.time.LocalDate;

@Data
@Inheritance
@AllArgsConstructor
@NoArgsConstructor
@Entity
public abstract class Person {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    protected Long id;
    protected String lastName;
    protected String firstName;
    protected LocalDate dateOfBirth;
    protected String address;

    public Person(Long id) {
        this.id = id;
    }
}
