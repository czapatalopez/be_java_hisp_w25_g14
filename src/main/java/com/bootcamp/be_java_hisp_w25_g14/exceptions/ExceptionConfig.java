package com.bootcamp.be_java_hisp_w25_g14.exceptions;

import com.bootcamp.be_java_hisp_w25_g14.dto.MessageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(NoFoundException.class)
    public ResponseEntity<?> noFound(NoFoundException ex){
        return ResponseEntity.status(400).body(new MessageDto(ex.getMessage(), ""));
    }
    @ExceptionHandler(FollowException.class)
    public ResponseEntity<?> follow(FollowException ex){
        return ResponseEntity.status(400).body(new MessageDto(ex.getMessage(), ""));
    }

    @ExceptionHandler(NotSellerException.class)
    public ResponseEntity<?> notASeller(NotSellerException ex){
        return ResponseEntity.status(400).body(new MessageDto(ex.getMessage(), ""));
    }

    @ExceptionHandler(NotValidDateException.class)
    public ResponseEntity<?> notValidDate(NotValidDateException ex){
        return ResponseEntity.status(400).body(new MessageDto(ex.getMessage(), ""));
    }
}
