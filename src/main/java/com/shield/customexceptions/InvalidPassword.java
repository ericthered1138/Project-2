package com.shield.customexceptions;

public class InvalidPassword extends RuntimeException{
    public InvalidPassword(String message){
        super(message);
    }
}