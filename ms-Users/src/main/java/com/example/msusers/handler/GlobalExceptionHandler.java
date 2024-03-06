package com.example.msusers.handler;

import com.example.msusers.exceptions.NotFoundException;
import com.example.msusers.model.host.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ExceptionResponse handleNotFoundException (NotFoundException exception){

        log.error("ActionLog.handle.error: {} ",exception);

        return ExceptionResponse.builder()
                .message(exception.getMessage())
                .status(exception.getStatus())
                .occurredAt(exception.getOccurredAt())
                .build();

    }

}


