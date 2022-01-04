package com.shield.customexceptions;

public class CommentIsTooManyCharacters extends RuntimeException{
    public CommentIsTooManyCharacters(String message){
        super(message);
    }
}
