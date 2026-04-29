package com.sakshi.springbootwebserver.advices;

public class ApiResponse<T> {

    //Type T generic T

    private T data;
    private ApiError error;

    //response will have either data or NULL..
}
