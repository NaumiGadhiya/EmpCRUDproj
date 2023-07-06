package com.emp.adviceControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class EmpExceptionsHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){

//		Map<String, String> mapError=new HashMap<>();
//		e.getBindingResult().getAllErrors().forEach(error->{
//			String fieldName=((FieldError)error).getField();
//			String fieldError=error.getDefaultMessage();
//			mapError.put(fieldName, fieldError);
//		});

        Map<String, String> mapError=new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error->{
            mapError.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<Map<String,String>>(mapError, HttpStatus.BAD_REQUEST);
    }


}
