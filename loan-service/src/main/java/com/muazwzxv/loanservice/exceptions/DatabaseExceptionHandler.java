package com.muazwzxv.loanservice.exceptions;

import com.muazwzxv.loanservice.dto.InternalErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.QueryTimeoutException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class DatabaseExceptionHandler {
    @ExceptionHandler({
        // Database connection issues
        CannotCreateTransactionException.class,
        DataSourceLookupFailureException.class,

        // Transaction failures
        TransactionSystemException.class,
        UnexpectedRollbackException.class,

        // JPA/Hibernate runtime errors
        JpaSystemException.class,
        HibernateException.class,

        // General data access failures
        DataAccessResourceFailureException.class,
        QueryTimeoutException.class,

        // SQL/JDBC failures
        SQLException.class
    })
    public ResponseEntity<InternalErrorDto> handleProductionDatabaseError(Exception ex) {
        log.error("Internal database error: {}", ex.getClass().getSimpleName(), ex);
        // Return generic 500 response to client
        InternalErrorDto error = InternalErrorDto.builder()
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .error("Internal Server Error")
            .message("Try again later")
            .timestamp(LocalDateTime.now())
            .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
