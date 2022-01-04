package com.shield.customexceptions;

public class InvalidUsername extends RuntimeException{
    public InvalidUsername(String message){
        super(message);
    }
}
