package com.wi.quiz.Repositories;

import com.wi.quiz.Entities.Person;
import com.wi.quiz.Entities.Subject;
import com.wi.quiz.Entities.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByFirstNameAndLastName(String firstName, String lastName);
}
