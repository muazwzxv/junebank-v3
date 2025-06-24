package com.muazwzxv.cardservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InternalErrorDto {
    private int status;
    private String error;
    private String message;
    private LocalDateTime timestamp;
}
