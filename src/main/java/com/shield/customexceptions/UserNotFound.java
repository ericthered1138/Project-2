package com.shield.customexceptions;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String message){
        super(message);
    }
}
