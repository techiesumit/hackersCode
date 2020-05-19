
package com.example.pojo.util;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

//@RunWith(PowerMockRunner.class)
//@RunWith(PowerMockRunner.class)
class PropertyValidatorTest {
    @InjectMocks
    private PropertyValidator propertyValidator;
    @Mock
    private  Object requestClassMock;
    @Mock
    private ValidatorFactory validatorFactoryMock;
    @Mock
    private Validator validatorMock;
    @Mock
    private ConstraintViolation<Object> constraintViolationMock;

   @Test
    public void validateFields_withValidRequest_noValidationError(){

      //mockStatic(Validation.class, new Class<?>[]{});
       //spy(Validation.class);
       PowerMockito.mockStatic(Validation.class);
         when(Validation.buildDefaultValidatorFactory()).thenReturn(validatorFactoryMock);
         when(validatorFactoryMock.getValidator()).thenReturn(validatorMock);
         when(validatorMock.validate(requestClassMock)).thenReturn(new HashSet<>());
         propertyValidator.validateFields(requestClassMock);
         Mockito.verify(validatorFactoryMock,Mockito.times(1));

     }

@Test(expected =RuntimeException.class)
    public void validateFields_withInValidRequest_throwValidationError(){
        //PowerMockito.mockStatic(Validation.class);
        spy(Validation.class);
        when(Validation.buildDefaultValidatorFactory()).thenReturn(validatorFactoryMock);
        when(validatorFactoryMock.getValidator()).thenReturn(validatorMock);
        Set<ConstraintViolation<Object>> constraintViolations = new HashSet<>();
        constraintViolations.add(constraintViolationMock);
        when(validatorMock.validate(requestClassMock)).thenReturn(constraintViolations);
        propertyValidator.validateFields(requestClassMock);

    }

}
