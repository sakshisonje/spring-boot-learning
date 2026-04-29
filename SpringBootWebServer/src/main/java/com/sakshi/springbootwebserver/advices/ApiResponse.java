package com.sakshi.springbootwebserver.advices;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
    //Type T generic T

    private LocalDateTime timeStamp;

    private T data;
    private ApiError error;

    //response will have either data or NULL..


    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this(); //calls default constructor above one
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this(); //calls default constructor timestamp one
        this.error = error;
    }
}
