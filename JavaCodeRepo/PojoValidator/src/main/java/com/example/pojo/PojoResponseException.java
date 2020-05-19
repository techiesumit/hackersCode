package com.example.pojo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

import java.nio.charset.Charset;

public class PojoResponseException extends HttpStatusCodeException {
    //private final PojoResponseException pojoResponseException;

    public PojoResponseException(HttpStatus httpStatus, String statusText, HttpHeaders httpHeaders, byte[] reBytes, Charset reCharset, PojoRespone pojoRespone){
        super(httpStatus,statusText,httpHeaders,reBytes,reCharset);
    }

}
