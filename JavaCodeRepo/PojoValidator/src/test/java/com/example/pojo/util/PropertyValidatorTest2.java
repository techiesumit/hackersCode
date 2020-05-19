package com.example.pojo.util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashSet;

import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PropertyValidator.class)
public class PropertyValidatorTest2 {
    /*@Mock
    private Validation validation;*/
    @InjectMocks
    private PropertyValidator propertyValidator;
    //private ValidatorFactory validatorFactory;
    @Mock
    private Object requestClassMock;
    @Mock
    private ValidatorFactory validatorFactoryMock;
    @Mock
    private Validator validatorMock;

    @Before
    public void setUp() {
        propertyValidator = new PropertyValidator();
    }

    @Test
    public void validateFields_withValidRequest_noValidationError() {
        PowerMockito.mockStatic(Validation.class);
        when(Validation.buildDefaultValidatorFactory()).thenReturn(validatorFactoryMock);
        when(validatorFactoryMock.getValidator()).thenReturn(validatorMock);
        when(validatorMock.validate(requestClassMock)).thenReturn(new HashSet<>());
        propertyValidator.validateFields(requestClassMock);
        Mockito.verify(validatorFactoryMock, Mockito.times(1));

    }
}