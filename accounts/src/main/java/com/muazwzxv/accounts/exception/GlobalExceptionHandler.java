package com.muazwzxv.accounts.exception;

import com.muazwzxv.accounts.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Error handling logic when this specific `CustomerAlreadyExistsException` is being thrown
    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorDto> handleCustomerAlreadyExistException(CustomerAlreadyExistsException exception, WebRequest req) {
        ErrorDto errResponseDTO = new ErrorDto(
                req.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errResponseDTO, HttpStatus.BAD_REQUEST);
    }
}
