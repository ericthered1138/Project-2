package com.shield.customexceptions;

public class EmployeeIsNotAgent extends RuntimeException{
    public EmployeeIsNotAgent(String message){
        super(message);
    }
}
