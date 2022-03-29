package com.blz.exception.handling.user.registration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    public static boolean validateFirstName(String TestFirstName) throws UserRegistrationException {
        boolean result = false;
        try {
            if (TestFirstName == null || TestFirstName.isEmpty()) {
                throw new UserRegistrationException("Enter the valid first name");
            } else {
                String firstNamePattern = "^[A-Z]{1}[a-z]{2,}$";
                result = validatePattern(firstNamePattern, TestFirstName);
                if(result)
                    return true;
                throw new UserRegistrationException("Entered First Name is Invalid");
            }
        } catch (UserRegistrationException validity) {
            System.out.println(validity.getMessage());
            throw new UserRegistrationException("Enter the valid first name");

        }
    }
    public static boolean validateLastName(String TestLastName) throws UserRegistrationException{
        boolean result = false;
        try{
            if(TestLastName == null || TestLastName.isEmpty()) {
                throw new UserRegistrationException("Enter the valid Last Name");
            } else {
                String lastNamePattern = "^[A-Z]{1}[a-z]{2,}$";
                result = validatePattern(lastNamePattern,TestLastName);
                if(result)
                    return true;
                throw new UserRegistrationException("Entered Last Name is Invalid");
            }
        } catch (UserRegistrationException validity){
            System.out.println(validity.getMessage());
            throw new UserRegistrationException("Enter the valid Last Name");
        }
    }

    public static boolean validateEmail(String TestEmailId) throws UserRegistrationException {
        boolean result = false;
        try{
            if(TestEmailId == null || TestEmailId.isEmpty()){
                throw new UserRegistrationException("Enter the Valid Email");
            } else {
                String emailPattern = "^[a-zA-Z0-9_+-]+([.][a-zA-Z0-9]+)*@[0-9a-zA-Z]+[.][a-zA-Z]{2,}+([.][a-zA-Z]{2,})?$";
                result = validatePattern(emailPattern,TestEmailId);
                if(result)
                    return true;
                throw new UserRegistrationException("Entered Email is Invalid");
            }
        } catch (UserRegistrationException validity) {
            System.out.println(validity.getMessage());
            throw new UserRegistrationException("Enter the Valid Email");
        }
    }
    public static boolean validateMobNumber(String TestNumber) throws UserRegistrationException {
        boolean result = false;
        try {
            if(TestNumber == null || TestNumber.isEmpty()){
                throw new UserRegistrationException("Enter the Valid Mobile Number");
            } else {
                String mobPattern = "^[0-9]{2}\s{1}[0-9]{10}$";
                result = validatePattern(mobPattern,TestNumber);
                if(result)
                    return true;
                throw new UserRegistrationException("Entered Mobile Number is Invalid");
            }
        } catch (UserRegistrationException validity){
            System.out.println(validity.getMessage());
            throw new UserRegistrationException("Enter the Valid Mobile Number");
        }
    }
    public static boolean validatePassword(String TestPassword) throws UserRegistrationException {
        boolean result = false;
        try {
            if(TestPassword == null || TestPassword.isEmpty()){
                throw new UserRegistrationException("Enter the Valid Password");
            } else {
                String passwordPattern = "^(?=.{8,})(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])[0-9a-zA-z]*[!@~#$%^&*?_][0-9a-zA-Z]*$";
                result = validatePattern(passwordPattern,TestPassword);
                if(result)
                    return true;
                throw new UserRegistrationException("Entered Password is Invalid");
            }
        } catch (UserRegistrationException validity){
            System.out.println(validity.getMessage());
            throw new UserRegistrationException("Enter the Valid Password");
        }
    }

    public static boolean validatePattern(String inbuiltPattern, String TestEmailId) {
        Pattern pattern = Pattern.compile(inbuiltPattern);
        Matcher matcher = pattern.matcher(TestEmailId);
        return matcher.matches();
    }

}
