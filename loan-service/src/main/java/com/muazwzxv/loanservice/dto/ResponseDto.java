package com.muazwzxv.loanservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseDto {
    private String statusCode;
    private String statusMsg;
}
