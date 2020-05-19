package com.example.pojo.util;

import com.example.pojo.RequestPojo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import static org.mockito.Mockito.when;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PropertyValidatorInegrationTest {
    private Validator validator;
    @Mock
    private PropertyValidator propertyValidator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validateFields_withValidData_noError() {
        final RequestPojo requestPojo = new RequestPojo();
        getValidData(requestPojo);
        Set<ConstraintViolation<Object>> violations = validator.validate(requestPojo);
        assertEquals(violations.isEmpty(), true);
    }
    @Test
    public void validateFields_withInvalidData_withViolations() {
        final RequestPojo requestPojo = new RequestPojo();
        getInvalidData(requestPojo);
        Set<ConstraintViolation<Object>> violations = validator.validate(requestPojo);
        assertEquals(violations.isEmpty(), false);
    }

    private void getValidData(RequestPojo requestPojo) {
        requestPojo.setCorrelationId("12345");
        requestPojo.setId("12142");
        requestPojo.setName("Sumit Chawla");
        requestPojo.setRequestId("100101");
    }

    private void getInvalidData(RequestPojo requestPojo) {
        requestPojo.setCorrelationId("12345");
        requestPojo.setId(" ");
        requestPojo.setName("Sumit Chawla");
        requestPojo.setRequestId("100101");
    }
}