package com.shield.customexceptions;

public class NegativeClaimAmount extends RuntimeException{
    public NegativeClaimAmount(String message){
        super(message);
    }
}
