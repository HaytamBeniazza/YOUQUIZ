package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Teacher.TeacherDto;
import com.wi.quiz.DTO.Teacher.TeacherDtoRsp;
import com.wi.quiz.Entities.Teacher;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.TeacherRepository;
import com.wi.quiz.Services.Inter.TeacherService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    
    private final TeacherRepository teacherRepository;
    
    private final ModelMapper modelMapper;

    @Override
    public TeacherDtoRsp save(TeacherDto teacherDto) {
        Teacher teacher = modelMapper.map(teacherDto, Teacher.class);
        teacher = teacherRepository.save(teacher);
        return modelMapper.map(teacher, TeacherDtoRsp.class);
    }

    @Override
    public TeacherDtoRsp update(TeacherDto teacherDto, Long aLong) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(aLong);
        if (optionalTeacher.isEmpty()) {
            throw new NotFoundEx("Teacher not found for id: " + aLong);
        }
        Teacher teacher = modelMapper.map(teacherDto, Teacher.class);
        teacher = teacherRepository.save(teacher);
        return modelMapper.map(teacher, TeacherDtoRsp.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(aLong);
        if (optionalTeacher.isEmpty()) {
            throw new NotFoundEx("Teacher not found for id: " + aLong);
        }
        teacherRepository.deleteById(aLong);
        return teacherRepository.findById(aLong).isEmpty();
    }

    @Override
    public TeacherDtoRsp findOne(Long aLong) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(aLong);
        if (optionalTeacher.isEmpty()) {
            throw new NotFoundEx("Teacher not found for id: " + aLong);
        }
        Teacher teacher = optionalTeacher.get();
        return modelMapper.map(teacher, TeacherDtoRsp.class);
    }

    @Override
    public List<TeacherDtoRsp> findAll() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(teacher -> modelMapper.map(teacher, TeacherDtoRsp.class)).collect(java.util.stream.Collectors.toList());
    }
}
