package com.muazwzxv.cardservice.exceptions;

import com.muazwzxv.cardservice.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        Map<String, String> validationErrs = new HashMap<>();
        List<ObjectError> validationErrList = ex.getBindingResult().getAllErrors();

        validationErrList.forEach(objectError -> {
            String fieldName = ((FieldError) objectError).getField();
            String validationMsg = objectError.getDefaultMessage();
            validationErrs.put(fieldName, validationMsg);
        });

        // TODO: come up with a better validation error payload
        return new ResponseEntity<>(validationErrs, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest req) {
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        ErrorDto errResponseDTO = ErrorDto.builder()
            .apiPath(req.getDescription(false))
            .errorCode(statusCode)
            .errorMessage(exception.getMessage())
            .errorTime(LocalDateTime.now())
            .build();
        return new ResponseEntity<>(errResponseDTO, statusCode);
    }

    @ExceptionHandler(UnexpectedErrorException.class)
    public ResponseEntity<ErrorDto> handleUnexpectedException(UnexpectedErrorException exception, WebRequest req) {
        HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDto errResponseDTO = ErrorDto.builder()
            .apiPath(req.getDescription(false))
            .errorCode(statusCode)
            .errorMessage("INTERNAL_ERROR")
            .errorTime(LocalDateTime.now())
            .build();
        return new ResponseEntity<>(errResponseDTO, statusCode);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorDto> handleDataAccessException(DataAccessException exception, WebRequest req) {
        log.error("Database error occurred - Path: {}, Exception Type: {}, Message: {}",
            req.getDescription(false),
            exception.getClass().getSimpleName(),
            exception.getMessage(),
            exception);

        HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDto errResponseDTO = ErrorDto.builder()
            .apiPath(req.getDescription(false))
            .errorCode(statusCode)
            .errorMessage("INTERNAL_SERVER")
            .errorTime(LocalDateTime.now())
            .build();
        return new ResponseEntity<>(errResponseDTO, statusCode);
    }

    @ExceptionHandler(BadInputException.class)
    public ResponseEntity<ErrorDto> handleBadInputException(BadInputException exception, WebRequest req) {
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        ErrorDto errResponseDTO = ErrorDto.builder()
            .apiPath(req.getDescription(false))
            .errorCode(statusCode)
            .errorMessage(exception.getMessage())
            .errorTime(LocalDateTime.now())
            .build();
        return new ResponseEntity<>(errResponseDTO, statusCode);
    }
}
