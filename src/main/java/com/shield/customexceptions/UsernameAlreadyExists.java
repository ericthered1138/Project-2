
package com.shield.customexceptions;

public class UsernameAlreadyExists extends RuntimeException{
    public UsernameAlreadyExists(String message){
            super(message);
        }
}