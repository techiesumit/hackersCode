package com.example.pojo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Slf4j
@Component
public class PropertyValidator {

	public  void validateFields(Object requestClass) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Object>> propertyViolation = validator.validate(requestClass);
		List<String> errorList = new ArrayList<>();

		if(propertyViolation.size() >0) {
			errorList.addAll(propertyViolation.stream().map(p->p.getMessage()).collect(Collectors.toList()));
			ErrorMessagePojo errorMessagePojos = ErrorMessagePojo.builder()
					.errorMessage(errorList)
					.statusCode(HttpStatus.BAD_REQUEST)
					.build();
					//errorMessagePojos.addAll(propertyViolation.stream().map(p-> toErrorMsgPojo.apply(p.getMessage())).collect(Collectors.toList()));
			logJsonError(errorMessagePojos);
		//	propertyViolation.forEach(p-> log.info(p.getMessage()));
			//System.out.println(errorList.toString());
			throw new RuntimeException("Bad Request");
		}
	}
	private Function<List<String>, ErrorMessagePojo> toErrorMsgPojo = (msg) ->{
		return ErrorMessagePojo.builder().errorMessage(msg).statusCode(HttpStatus.BAD_REQUEST).build();
	};
	private  void logJsonError(ErrorMessagePojo msgPojo){
		ObjectMapper objectMapper = new  ObjectMapper();

		try {
			String json=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(msgPojo);
			log.info(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
