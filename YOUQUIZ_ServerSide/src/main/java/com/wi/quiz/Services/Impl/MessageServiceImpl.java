package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Message.MessageDto;
import com.wi.quiz.DTO.Message.MessageDtoRsp;
import com.wi.quiz.DTO.Person.PersonDto;
import com.wi.quiz.DTO.Person.PersonDtoLogin;
import com.wi.quiz.Entities.Message;
import com.wi.quiz.Entities.Person;
import com.wi.quiz.Entities.Room;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.MessageRepository;
import com.wi.quiz.Repositories.PersonRepository;
import com.wi.quiz.Repositories.RoomMembersRepository;
import com.wi.quiz.Repositories.RoomRepository;
import com.wi.quiz.Services.Inter.MessageService;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final PersonRepository personRepository;
    private final RoomMembersRepository membersRepository;
    private final MessageRepository messageRepository;
    private final RoomRepository roomRepository;

    private final ModelMapper modelMapper;

    @Override
    public MessageDtoRsp save(MessageDto messageDto) {
        Person person = personRepository.findById(messageDto.getSender_id())
                .orElseThrow(() -> new NotFoundEx("Person not found"));
        Room room = roomRepository.findById(messageDto.getRoom_id())
                .orElseThrow(() -> new NotFoundEx("Room not found"));
        Message message = modelMapper.map(messageDto, Message.class);
        message.setSender(person);
        message.setRoom(room);
        message.setTime(LocalTime.now());
        System.out.println(message.getSender().getId());
        message = messageRepository.save(message);
        return modelMapper.map(message, MessageDtoRsp.class);
    }

    @Override
    public MessageDtoRsp update(MessageDto messageDto, Long aLong) {
        messageRepository.findById(aLong).orElseThrow(() -> new NotFoundEx("Message not found"));
        Person person = personRepository.findById(messageDto.getSender_id())
                .orElseThrow(() -> new NotFoundEx("Person not found"));
        Room room = roomRepository.findById(messageDto.getRoom_id())
                .orElseThrow(() -> new NotFoundEx("Room not found"));
        Message message = modelMapper.map(messageDto, Message.class);
        message.setSender(person);
        message.setRoom(room);
        message.setId(aLong);
        message.setTime(LocalTime.now());
        message = messageRepository.save(message);
        MessageDtoRsp messageDtoRsp = modelMapper.map(message, MessageDtoRsp.class);
        return messageDtoRsp;
    }

    @Override
    public Boolean delete(Long aLong) {
        return null;
    }

    @Override
    public MessageDtoRsp findOne(Long aLong) {
        return null;
    }

    @Override
    public List<MessageDtoRsp> findAll() {
        List<Message> messages = messageRepository.findAll();
        List<MessageDtoRsp> messageDtoRsps = messages.stream().map(message -> modelMapper.map(message, MessageDtoRsp.class)).toList();
        return messageDtoRsps;
    }

    @Override
    public List<MessageDtoRsp> findAll(Long room_id) {
        List<Message> messages = messageRepository.findAllByRoomId(room_id);
        return messages.stream().map(message -> modelMapper.map(message, MessageDtoRsp.class)).toList();
    }
}