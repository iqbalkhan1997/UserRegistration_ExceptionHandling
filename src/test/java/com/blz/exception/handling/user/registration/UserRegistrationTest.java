package com.blz.exception.handling.user.registration;

import org.junit.Assert;
import org.junit.Test;

public class UserRegistrationTest {
    private static final UserRegistration user = new UserRegistration();

/* handling exceptions to given first names of null,empty and improper
    5 exceptions test cases, Starts from 10th line and ends at 65th line */

    @Test
    public void HandleCustomExceptionForGivenImproperFirstNameWithNoMinimumCharacters() {
        try {
            boolean actual = user.validateFirstName("Mi");
            Assert.assertEquals(false,actual);
        } catch (UserRegistrationException e){
            System.out.println(e.getMessage());
            String expected= "Enter the valid first name";
            Assert.assertEquals(expected , e.getMessage());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void HandleCustomExceptionForGivenInvalidFirstNameWithNoUpperCaseAtStart() {
        try {
            boolean actual = user.validateFirstName("vgijhy");
            Assert.assertEquals(false,actual);
        } catch (UserRegistrationException e){
            String expected= "Enter the valid first name";
            Assert.assertEquals(expected,e.getMessage());
        }
    }

    @Test
    public void HandleCustomExceptionForGivenNullFirstName() {
        try {
            boolean actual = user.validateFirstName(null);
            Assert.assertEquals(false,actual);
        } catch (UserRegistrationException e){
            String expected= "Enter the valid first name";
            Assert.assertEquals(expected,e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void HandleCustomExceptionForGivenEmptyFirstName() {
        try {
            boolean actual = user.validateFirstName("");
            Assert.assertEquals(false,actual);
        } catch (UserRegistrationException e){
            String expected= "Enter the valid first name";
            Assert.assertEquals(expected,e.getMessage());
        }
    }

    @Test
    public void HandleNoCustomExceptionForGivenFirstNameWithOneUpperCaseAtStart() {
        try {
            boolean actual = user.validateFirstName("Iqbal");
            Assert.assertEquals(true,actual);
        } catch (UserRegistrationException e){
            String expected= "Enter the valid first name";
            Assert.assertEquals(expected,e.getMessage());
        }
    }


    /* handling exceptions to given last names of null,empty and improper
        5 Exceptions test cases , Starts from 75th line and ends at 129th line */


    @Test
    public void HandleCustomExceptionForGivenImproperLastNameWithNoMinimumCharacters() {
      try {
          boolean actual = user.validateLastName("Kh");
          Assert.assertFalse(actual);
      } catch (UserRegistrationException e){
          String expected = "Enter the valid Last Name";
          Assert.assertEquals(expected,e.getMessage());
      }
    }
    @Test
    public void HandleCustomExceptionForGivenInvalidLastNameWithNoUpperCaseAtStart() {
        try {
            boolean actual = user.validateLastName("vgijhy");
            Assert.assertFalse(actual);
        } catch (UserRegistrationException e){
            String expected= ("Enter the valid Last Name");
            Assert.assertEquals(expected,e.getMessage());
        }
    }

    @Test
    public void HandleCustomExceptionForGivenNullLastName() {
        try {
            boolean actual = user.validateLastName(null);
            Assert.assertFalse(actual);
        } catch (UserRegistrationException e){
            String expected= ("Enter the valid Last Name");
            Assert.assertEquals(expected,e.getMessage());
        }
    }

    @Test
    public void HandleCustomExceptionForGivenEmptyLastName() {
        try {
            boolean actual = user.validateLastName("");
            Assert.assertFalse(actual);
        } catch (UserRegistrationException e){
            String expected= ("Enter the valid Last Name");
            Assert.assertEquals(expected,e.getMessage());
        }
    }

    @Test
    public void HandleNoCustomExceptionForGivenLastNameWithOneUpperCaseAtStart() {
        try {
            boolean actual = user.validateLastName("Khan");
            Assert.assertTrue(actual);
            System.out.println("Entered Last Name is Valid");
        } catch (UserRegistrationException e){
            String expected= ("Enter the valid Last Name");
            Assert.assertEquals(expected,e.getMessage());
        }
    }

/*  handling exceptions to given improper email id's
        5 Exceptions test cases, Starts from 132nd line and ends at 129th line */

    @Test
    public void HandleCustomExceptionForGivenEmailWithNoMandatoryParts() {
        try {
            boolean actual = user.validateEmail("Khan");
            Assert.assertFalse(actual);
        } catch (UserRegistrationException e){
            String expected= ("Enter the Valid Email");
            Assert.assertEquals(expected,e.getMessage());
        }
    }

    @Test
    public void HandleCustomExceptionForGivenEmailWithOneMandatoryParts() {
        try {
            boolean actual = user.validateEmail("abc@.com.my");
            Assert.assertFalse(actual);
        } catch (UserRegistrationException e){
            String expected= ("Enter the Valid Email");
            Assert.assertEquals(expected,e.getMessage());
        }
    }
    @Test
    public void HandleCustomExceptionForGivenEmailWithTwoMandatoryParts() {
        try {
            boolean actual = user.validateEmail("abc123@gmail.a");
            Assert.assertFalse(actual);
        } catch (UserRegistrationException e){
            String expected= ("Enter the Valid Email");
            Assert.assertEquals(expected,e.getMessage());
        }
    }
    @Test
    public void HandleCustomExceptionForGivenEmailWithThreeMandatoryParts() {
        try {
            boolean actual = user.validateEmail("abc123@.com");
            Assert.assertFalse(actual);
        } catch (UserRegistrationException e){
            String expected= ("Enter the Valid Email");
            Assert.assertEquals(expected,e.getMessage());
        }
    }
    @Test
    public void HandleNoCustomExceptionForGivenEmailWithMandatoryParts() {
        try {
            boolean actual = user.validateEmail("abc-100@abc.net");
            Assert.assertTrue(actual);
            System.out.println("Entered Email is Valid");
        } catch (UserRegistrationException e){
            String expected= ("Enter the Valid Email");
            Assert.assertEquals(expected,e.getMessage());
        }
    }

/*  handling exceptions to given improper Mobile Numbers
        5 Exceptions test cases, Starts from 189th line and ends at 243rd line */

    @Test
    public void HandleCustomExceptionForGivenMobileNumberWithoutCountryCode() {
        try {
            boolean actual = user.validateMobNumber("9884772136");
            Assert.assertFalse(actual);
        } catch (UserRegistrationException e){
            String expected= ("Enter the Valid Mobile Number");
            Assert.assertEquals(expected,e.getMessage());
        }
    }

    @Test
    public void HandleCustomExceptionForGivenMobileNumberWithoutSpace() {
        try {
            boolean actual = user.validateMobNumber("919884772136");
            Assert.assertFalse(actual);
        } catch (UserRegistrationException e){
            String expected= ("Enter the Valid Mobile Number");
            Assert.assertEquals(expected,e.getMessage());
        }
    }

    @Test
    public void HandleCustomExceptionForGivenMobileNumberWithoutTenDigit() {
        try {
            boolean actual = user.validateMobNumber("91 58987");
            Assert.assertFalse(actual);
        } catch (UserRegistrationException e){
            String expected= ("Enter the Valid Mobile Number");
            Assert.assertEquals(expected,e.getMessage());
        }
    }

    @Test
    public void HandleCustomExceptionForGivenMobileNumberWithoutCountryCodeAndWithoutTenDigit() {
        try {
            boolean actual = user.validateMobNumber("");
            Assert.assertFalse(actual);
        } catch (UserRegistrationException e){
            String expected= ("Enter the Valid Mobile Number");
            Assert.assertEquals(expected,e.getMessage());
        }
    }

    @Test
    public void HandleNoCustomExceptionForGivenMobileNumber() {
        try {
            boolean actual = user.validateMobNumber("91 9884772136");
            Assert.assertTrue(actual);
            System.out.println("Entered Mobile Number is Valid");
        } catch (UserRegistrationException e){
            String expected= ("Enter the Valid Mobile Number");
            Assert.assertEquals(expected,e.getMessage());
        }
    }

    /*  handling exceptions to given improper Passwords
        5 Exceptions test cases, Starts from 246th line and ends at 313th line */

    @Test
    public void HandleCustomExceptionForGivenPasswordWithNoMinimumCharacters() {
        try {
            boolean actual = user.validatePassword("9Ua8#7");
            Assert.assertTrue(actual);
        } catch (UserRegistrationException e){
            String expected= ("Enter the Valid Password");
            Assert.assertEquals(expected,e.getMessage());
        }
    }

    @Test
    public void HandleCustomExceptionForGivenPasswordWithNoMinimumUpperCase() {
        try {
            boolean actual = user.validatePassword("98#da8#7");
            Assert.assertFalse(actual);
        } catch (UserRegistrationException e){
            String expected= ("Enter the Valid Password");
            Assert.assertEquals(expected,e.getMessage());
        }
    }

    @Test
    public void HandleCustomExceptionForGivenPasswordWithNoMinimumLowerCase() {
        try {
            boolean actual = user.validatePassword("9J#U8*7E");
            Assert.assertFalse(actual);
        } catch (UserRegistrationException e){
            String expected= ("Enter the Valid Password");
            Assert.assertEquals(expected,e.getMessage());
        }
    }

    @Test
    public void HandleCustomExceptionForGivenPasswordWithNoMinimumNumericValue() {
        try {
            boolean actual = user.validatePassword("&J#Ur*aE");
            Assert.assertFalse(actual);
        } catch (UserRegistrationException e){
            String expected= ("Enter the Valid Password");
            Assert.assertEquals(expected,e.getMessage());
        }
    }

    @Test
    public void HandleCustomExceptionForGivenPasswordWithNoExactSpecialCharacter() {
        try {
            boolean actual = user.validatePassword("&J#U12r*aE");
            Assert.assertFalse(actual);
        } catch (UserRegistrationException e){
            String expected= ("Enter the Valid Password");
            Assert.assertEquals(expected,e.getMessage());
        }
    }

    @Test
    public void HandleNoCustomExceptionForGivenPassword() {
        try {
            boolean actual = user.validatePassword("bRidg3!ab");
            Assert.assertTrue(actual);
            System.out.println("Entered Password is Valid");
        } catch (UserRegistrationException e){
            String expected= ("Enter the Valid Password");
            Assert.assertEquals(expected,e.getMessage());
        }
    }
}
