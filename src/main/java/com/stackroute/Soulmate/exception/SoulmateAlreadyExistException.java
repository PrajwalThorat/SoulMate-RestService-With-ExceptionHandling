package com.stackroute.Soulmate.exception;

public class SoulmateAlreadyExistException extends Exception{

    String message;

    public SoulmateAlreadyExistException(String message){
        this.message = message;
    }

    public SoulmateAlreadyExistException() {

    }
}
