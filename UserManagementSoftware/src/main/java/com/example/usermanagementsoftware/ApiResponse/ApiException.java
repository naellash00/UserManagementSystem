package com.example.usermanagementsoftware.ApiResponse;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
