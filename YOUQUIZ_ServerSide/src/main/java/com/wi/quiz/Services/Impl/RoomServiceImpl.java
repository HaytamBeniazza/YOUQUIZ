package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Room.RoomDto;
import com.wi.quiz.DTO.Room.RoomDtoRsp;
import com.wi.quiz.Entities.Person;
import com.wi.quiz.Entities.Room;
import com.wi.quiz.Entities.Student;
import com.wi.quiz.Entities.Teacher;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.PersonRepository;
import com.wi.quiz.Repositories.RoomRepository;
import com.wi.quiz.Repositories.StudentRepository;
import com.wi.quiz.Repositories.TeacherRepository;
import com.wi.quiz.Services.Inter.RoomService;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    private final PersonRepository personRepository;


    private final ModelMapper modelMapper;

    @Override
    public RoomDtoRsp save(RoomDto roomDto) {
        Person person = personRepository.findById(roomDto.getOwner_id()).orElseThrow(() -> new NotFoundEx("Person not found"));
        Room room = modelMapper.map(roomDto, Room.class);
        room.setOwner(person);
        room = roomRepository.save(room);
        RoomDtoRsp roomDtoRsp = modelMapper.map(room, RoomDtoRsp.class);
        return roomDtoRsp;
    }

    @Override
    public RoomDtoRsp update(RoomDto roomDto, Long aLong) {
        roomRepository.findById(aLong).orElseThrow(() -> new NotFoundEx("Room not found"));
        Person person = personRepository.findById(roomDto.getOwner_id()).orElseThrow(() -> new NotFoundEx("Person not found"));
        Room room = modelMapper.map(roomDto, Room.class);
        room.setOwner(person);
        room.setId(aLong);
        room = roomRepository.save(room);
        RoomDtoRsp roomDtoRsp = modelMapper.map(room, RoomDtoRsp.class);
        return roomDtoRsp;
    }

    @Override
    public Boolean delete(Long aLong) {
        return null;
    }

    @Override
    public RoomDtoRsp findOne(Long aLong) {
        return null;
    }
    
    @Override
    public List<RoomDtoRsp> findAll() {
        List<Room> rooms = roomRepository.findAll();
        List<RoomDtoRsp> roomDtoRsps = rooms.stream().map(room -> modelMapper.map(room, RoomDtoRsp.class)).toList();
        return roomDtoRsps;
    }
}
