package com.muazwzxv.accounts.exception;

import com.muazwzxv.accounts.dto.ErrorDto;
import com.muazwzxv.accounts.exception.accountException.AccountOperationException;
import com.muazwzxv.accounts.exception.accountException.NoAccountForUpdateException;
import com.muazwzxv.accounts.exception.customerException.CustomerAlreadyExistsException;
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
