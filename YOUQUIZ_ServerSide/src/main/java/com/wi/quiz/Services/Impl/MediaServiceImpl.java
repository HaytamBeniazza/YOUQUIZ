package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Media.MediaDto;
import com.wi.quiz.DTO.Media.MediaDtoRsp;
import com.wi.quiz.Entities.Media;
import com.wi.quiz.Entities.Question;
import com.wi.quiz.Exceptions.DuplicateEx;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.MediaRepository;
import com.wi.quiz.Repositories.QuestionRepository;
import com.wi.quiz.Services.Inter.MediaService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {
    
    private final MediaRepository mediaRepository;
    private final QuestionRepository questionRepository;
    
    private final ModelMapper modelMapper;




    @Override
    public MediaDtoRsp save(MediaDto mediaDto) {
        Media media = modelMapper.map(mediaDto, Media.class);
        checkIfMediaExist(mediaDto);
        Question question= questionRepository.findById(mediaDto.getQuestion_id()).orElseThrow(() -> new NotFoundEx("Question not found for id: " + mediaDto.getQuestion_id()));
        media.setQuestion(question);
        media = mediaRepository.save(media);
        return modelMapper.map(media, MediaDtoRsp.class);
    }

    @Override
    public MediaDtoRsp update(MediaDto mediaDto, Long aLong) {
        Optional<Media> optionalMedia = mediaRepository.findById(aLong);
        if (optionalMedia.isEmpty()) {
            throw new NotFoundEx("Media not found for id: " + aLong);
        }
        Media media = modelMapper.map(mediaDto, Media.class);
        checkIfMediaExist(mediaDto);
        Question question= questionRepository.findById(mediaDto.getQuestion_id()).orElseThrow(() -> new NotFoundEx("Question not found for id: " + mediaDto.getQuestion_id()));
        media.setQuestion(question);
        media.setId(aLong);
        media = mediaRepository.save(media);
        return modelMapper.map(media, MediaDtoRsp.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<Media> optionalMedia = mediaRepository.findById(aLong);
        if (optionalMedia.isEmpty()) {
            throw new NotFoundEx("Media not found for id: " + aLong);
        }
        mediaRepository.deleteById(aLong);
        return mediaRepository.findById(aLong).isEmpty();
    }

    @Override
    public MediaDtoRsp findOne(Long aLong) {
        Optional<Media> optionalMedia = mediaRepository.findById(aLong);
        if (optionalMedia.isEmpty()) {
            throw new NotFoundEx("Media not found for id: " + aLong);
        }
        Media media = optionalMedia.get();
        return modelMapper.map(media, MediaDtoRsp.class);
    }

    @Override
    public List<MediaDtoRsp> findAll() {
        List<Media> mediaList = mediaRepository.findAll();
        return mediaList.stream().map(media -> modelMapper.map(media, MediaDtoRsp.class)).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public void checkIfMediaExist(MediaDto mediaDto) {
        Optional<Media> optionalMedia = mediaRepository.findBySrcAndTypeAndQuestionId(mediaDto.getSrc(), mediaDto.getType(), mediaDto.getQuestion_id());
        if (optionalMedia.isPresent()) {
            throw new DuplicateEx("Media already exist");
        }
    }
}
