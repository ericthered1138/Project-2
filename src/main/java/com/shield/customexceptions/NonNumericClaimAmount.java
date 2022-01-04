package com.shield.customexceptions;

public class NonNumericClaimAmount extends RuntimeException{
    public NonNumericClaimAmount(String message){
            super(message);
        }
}
