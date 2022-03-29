package com.blz.exception.handling.user.registration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class UserRegistrationParameterisedTest {
    private final String emailId;
    private final boolean expectedResult;
    UserRegistration validate = new UserRegistration();

    public UserRegistrationParameterisedTest(String emailId, boolean result) {
        this.emailId = emailId;
        this.expectedResult = result;
    }

    @Parameterized.Parameters
    public static Collection emailIdsWithExpectedResult() {
        List<Object[]> objects = Arrays.asList(new Object[][]
                {
                        {"abc@yahoo.com", true},
                        {"abc-100@yahoo.com", true},
                        {"abc.100@yahoo.com", true},
                        {"abc111@abc.com", true},
                        {"abc-100@abc.net", true},
                        {"abc.100@abc.com.au", true},
                        {"abc@1.com", true},
                        {"abc@gmail.com.com", true},
                        {"abc+100@gmail.com", true},
                        {"abc", false},
                        {"abc@.com.my", false},
                        {"abc123@gmail.a", false},
                        {"abc123@.com", false},
                        {"abc123@.com.com", false},
                        {".abc@abc.com", false},
                        {"abc()*@gmail.com", false},
                        {"abc@%*.com", false},
                        {"abc..2002@gmail.com", false},
                        {"abc.@gmail.com", false},
                        {"abc@abc@gmail.com", false},
                        {"abc@gmail.com.1a", false},
                        {"abc@gmail.com.aa.au", false}

                }
        );
        return objects;
    }


    @Test
    public void givenEmailIds_WithDifferentScenariosShouldReturnExpectedResult() throws UserRegistrationException {
        try{
            Assert.assertEquals(expectedResult, validate.validateEmail(emailId));
            System.out.println("Entered Mail is Valid");
        } catch (UserRegistrationException e){
            String expected= ("Enter the Valid Email");
            Assert.assertEquals(expected,e.getMessage());
        }

    }

}
