package com.shield.customexceptions;

public class InvalidApproval extends RuntimeException{
    public InvalidApproval(String message) { super(message); }
}
