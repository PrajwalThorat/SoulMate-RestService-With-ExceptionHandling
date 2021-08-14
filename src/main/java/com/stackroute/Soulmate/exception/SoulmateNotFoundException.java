package com.stackroute.Soulmate.exception;

public class SoulmateNotFoundException extends Exception {

     String message;

    public SoulmateNotFoundException(String message){
        this.message = message;
    }


    public SoulmateNotFoundException() {

    }
}
