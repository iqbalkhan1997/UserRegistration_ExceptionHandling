package com.blz.exception.handling.user.registration;

public class UserRegistrationException extends Exception{
    public static String message;

    UserRegistrationException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
