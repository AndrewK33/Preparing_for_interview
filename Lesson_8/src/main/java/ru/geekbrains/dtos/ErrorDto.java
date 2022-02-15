package ru.geekbrains.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ErrorDto {

    private LocalDateTime timeStamp;

    private String message;


    public ErrorDto(String message) {
        this.timeStamp = LocalDateTime.now();
        this.message = message;
    }
}
