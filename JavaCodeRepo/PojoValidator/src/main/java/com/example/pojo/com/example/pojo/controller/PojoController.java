package com.example.pojo.com.example.pojo.controller;

import com.example.pojo.PojoRespone;
import com.example.pojo.RequestPojo;
import com.example.pojo.util.PropertyValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

import static org.springframework.http.HttpStatus.CONFLICT;

@Slf4j
@RestController
@RequestMapping("/api")

public class PojoController {
    @Autowired
    private PropertyValidator propertyValidator;
    @PostMapping(value = "/pojo", consumes = "application/json")
    public void save(@RequestBody RequestPojo requestPojo) {
        propertyValidator.validateFields(requestPojo);
        log.info("Request " + requestPojo.toString());
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    public ResponseEntity<PojoRespone> handleException(final Exception e) {
        PojoRespone pojoRespone = new PojoRespone();
       // pojoRespone.(e.getMessage());
        return new ResponseEntity<>(pojoRespone, HttpStatus.BAD_REQUEST);

    }
}
