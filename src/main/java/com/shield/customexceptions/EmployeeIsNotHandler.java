package com.shield.customexceptions;

public class EmployeeIsNotHandler extends RuntimeException{
    public EmployeeIsNotHandler(String message){
        super(message);
    }
}
