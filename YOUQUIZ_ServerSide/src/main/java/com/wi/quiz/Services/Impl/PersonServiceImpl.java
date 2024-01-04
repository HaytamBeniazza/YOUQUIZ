package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Person.PersonDtoLogin;
import com.wi.quiz.Entities.Person;
import com.wi.quiz.Repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl {
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    public Optional<PersonDtoLogin> login(PersonDtoLogin personDtoLogin) {
        Optional<Person> person = personRepository.findByFirstNameAndLastName(personDtoLogin.getFirstName(), personDtoLogin.getLastName());
        return person.map(value -> modelMapper.map(value, PersonDtoLogin.class));
    }
}