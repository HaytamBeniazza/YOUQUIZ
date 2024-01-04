package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.RoomMembers.RoomMembersDto;
import com.wi.quiz.DTO.RoomMembers.RoomMembersDtoRsp;
import com.wi.quiz.Entities.Person;
import com.wi.quiz.Entities.Room;
import com.wi.quiz.Entities.RoomMembers;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.PersonRepository;
import com.wi.quiz.Repositories.RoomMembersRepository;
import com.wi.quiz.Repositories.RoomRepository;
import com.wi.quiz.Services.Inter.RoomMembersService;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomMembersServiceImpl implements RoomMembersService {

    private final PersonRepository personRepository;
    private final RoomMembersRepository membersRepository;
    private final RoomRepository roomRepository;

    private final ModelMapper modelMapper;

    @Override
    public RoomMembersDtoRsp save(RoomMembersDto roomMembersDto) {
        Person person = personRepository.findById(roomMembersDto.getMember_id())
                .orElseThrow(() -> new NotFoundEx("Person not found"));
        Room room = roomRepository.findById(roomMembersDto.getRoom_id())
                .orElseThrow(() -> new NotFoundEx("Room not found"));
        RoomMembers roomMember = modelMapper.map(roomMembersDto, RoomMembers.class);
        roomMember.setMember(person);
        roomMember.setRoom(room);
        roomMember = membersRepository.save(roomMember);
        RoomMembersDtoRsp roomMembersDtoRsp = modelMapper.map(roomMember, RoomMembersDtoRsp.class);
        return roomMembersDtoRsp;
    }

    @Override
    public RoomMembersDtoRsp update(RoomMembersDto roomMembersDto, Long aLong) {
        membersRepository.findById(aLong).orElseThrow(() -> new NotFoundEx("RoomMembers not found"));
        Person person = personRepository.findById(roomMembersDto.getMember_id())
                .orElseThrow(() -> new NotFoundEx("Person not found"));
        Room room = roomRepository.findById(roomMembersDto.getRoom_id())
                .orElseThrow(() -> new NotFoundEx("Room not found"));
        RoomMembers roomMember = modelMapper.map(roomMembersDto, RoomMembers.class);
        roomMember.setMember(person);
        roomMember.setRoom(room);
        roomMember.setId(aLong);
        roomMember = membersRepository.save(roomMember);
        RoomMembersDtoRsp roomMembersDtoRsp = modelMapper.map(roomMember, RoomMembersDtoRsp.class);
        return roomMembersDtoRsp;
    }

    @Override
    public Boolean delete(Long aLong) {
        return null;
    }

    @Override
    public RoomMembersDtoRsp findOne(Long aLong) {
        return null;
    }

    @Override
    public List<RoomMembersDtoRsp> findAll() {
        List<RoomMembers> roomMembers = membersRepository.findAll();
        List<RoomMembersDtoRsp> roomMembersDtoRsps = roomMembers.stream()
                .map(roomMember -> modelMapper.map(roomMember, RoomMembersDtoRsp.class)).toList();
        return roomMembersDtoRsps;
    }
}
