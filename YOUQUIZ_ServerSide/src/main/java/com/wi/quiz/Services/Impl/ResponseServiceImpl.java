package com.wi.quiz.Services.Impl;

import com.wi.quiz.DTO.Response.ResponseDto;
import com.wi.quiz.DTO.Response.ResponseDtoRsp;
import com.wi.quiz.Entities.Response;
import com.wi.quiz.Exceptions.NotFoundEx;
import com.wi.quiz.Repositories.ResponseRepository;
import com.wi.quiz.Services.Inter.ResponseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResponseServiceImpl implements ResponseService {
    
    private final ResponseRepository responseRepository;
    
    private final ModelMapper modelMapper;


    @Override
    public ResponseDtoRsp save(ResponseDto responseDto) {
        
            Response response = modelMapper.map(responseDto, Response.class);
            response= responseRepository.save(response);
            return modelMapper.map(response, ResponseDtoRsp.class);
        
    }

    @Override
    public ResponseDtoRsp update(ResponseDto responseDto, Long aLong) {
        
            Response response = modelMapper.map(responseDto, Response.class);
            response.setId(aLong);
            response= responseRepository.save(response);
            return modelMapper.map(response, ResponseDtoRsp.class);
        
    }

    @Override
    public Boolean delete(Long aLong) {
        
            Optional<Response> response = responseRepository.findById(aLong);
            if (response.isEmpty()) {
                throw new NotFoundEx("Response not found for id: " + aLong);
            }
            responseRepository.deleteById(aLong);
            return responseRepository.findById(aLong).isEmpty();
        
    }

    @Override
    public ResponseDtoRsp findOne(Long aLong) {
        
            Optional<Response> response = responseRepository.findById(aLong);
            if (response.isEmpty()) {
                throw new NotFoundEx("Response not found for id: " + aLong);
            }
            return modelMapper.map(response.get(), ResponseDtoRsp.class);
        
    }

    @Override
    public List<ResponseDtoRsp> findAll() {

        List<Response> responses = responseRepository.findAll();
        return  responses.stream().map(response -> modelMapper.map(response, ResponseDtoRsp.class)).collect(java.util.stream.Collectors.toList());
        
    }
}
