package com.example.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private String message;
    private Date timestamp;

    public ErrorResponse(String message) {
        this.message = message;
        this.timestamp = new Date();
    }
}
