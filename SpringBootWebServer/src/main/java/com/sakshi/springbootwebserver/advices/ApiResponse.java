package com.sakshi.springbootwebserver.advices;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
    //Type T generic T

//    @Pattern(regexp = "hh-mm-ss dd-mm-yyyy")
    @JsonFormat(pattern = "hh:mm:ss dd-MM-yyyy")
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
