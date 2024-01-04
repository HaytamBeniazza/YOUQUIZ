package com.wi.quiz.DTO.Person;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
@Data
public class PersonDto {
    protected Long id;
    @NotNull
    protected String lastName;
    @NotNull
    protected String firstName;
    @NotNull
    protected LocalDate dateOfBirth;
    @NotNull
    protected String address;
}
