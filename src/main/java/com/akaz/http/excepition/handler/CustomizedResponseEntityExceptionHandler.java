package com.akaz.http.excepition.handler;

import com.akaz.http.excepition.ExceptionTemplate;
import com.akaz.http.excepition.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionTemplate> handlerAllException(
            Exception exception,
            WebRequest request
    ){
        ExceptionTemplate template = new ExceptionTemplate(
                new Date(),
                exception.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(template, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionTemplate> hanlderResourceNotFoundException(
            Exception exception,
            WebRequest request
    ){
        ExceptionTemplate template = new ExceptionTemplate(
                new Date(),
                exception.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(template, HttpStatus.NOT_FOUND);
    }
}
