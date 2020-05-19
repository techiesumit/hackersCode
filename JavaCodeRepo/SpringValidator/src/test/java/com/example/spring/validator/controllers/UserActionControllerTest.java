package com.example.spring.validator.controllers;

import com.example.spring.validator.entity.UserRequestEntityPojo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

class UserActionControllerTest {
    UserActionController userActionController = new UserActionController();

    @Test
    void testAddUser() {
        ResponseEntity<String> result = userActionController.addUser(new UserRequestEntityPojo("id", "fname", "lname"));
        Assertions.assertEquals("200 OK", result);
    }

    @Test
    void testHandleValidationExceptions() {
        Map<String, String> result = userActionController.handleValidationExceptions(null);
        Assertions.assertEquals(new HashMap<String, String>() {{
            put("String", "String");
        }}, result);
    }
}
