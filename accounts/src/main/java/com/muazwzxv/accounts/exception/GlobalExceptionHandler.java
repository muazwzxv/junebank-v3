package com.muazwzxv.accounts.exception;

import com.muazwzxv.accounts.dto.ErrorDto;
import com.muazwzxv.accounts.exception.accountException.AccountOperationException;
import com.muazwzxv.accounts.exception.accountException.NoAccountForUpdateException;
import com.muazwzxv.accounts.exception.customerException.CustomerAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorDto> handleCustomerAlreadyExistException(CustomerAlreadyExistsException exception, WebRequest req) {
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        ErrorDto errResponseDTO = new ErrorDto(
                req.getDescription(false),
                statusCode,
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errResponseDTO, statusCode);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest req) {
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        ErrorDto errResponseDTO = new ErrorDto(
                req.getDescription(false),
                statusCode,
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errResponseDTO, statusCode);
    }

    @ExceptionHandler(NoAccountForUpdateException.class)
    public ResponseEntity<ErrorDto> handleNoAccountForUpdateException(NoAccountForUpdateException exception, WebRequest req) {
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        ErrorDto errResponseDto = new ErrorDto(
                req.getDescription(false),
                statusCode,
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errResponseDto, statusCode);
    }

    @ExceptionHandler(AccountOperationException.class)
    public ResponseEntity<ErrorDto> handleQueryTimeoutException(AccountOperationException exception, WebRequest req) {
        HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDto errResponseDto = new ErrorDto(
                req.getDescription(false),
                statusCode,
                "INTERNAL_ERROR",
                LocalDateTime.now());
        return new ResponseEntity<>(errResponseDto, statusCode);
    }

    @ExceptionHandler(UnexpectedErrorException.class)
    public ResponseEntity<ErrorDto> handleUnexpectedException(UnexpectedErrorException exception, WebRequest req) {
        HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDto errResponseDto = new ErrorDto(
                req.getDescription(false),
                statusCode,
                "INTERNAL_ERROR",
                LocalDateTime.now());
        return new ResponseEntity<>(errResponseDto, statusCode);
    }
}
