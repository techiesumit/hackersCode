package com.example.pojo.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessagePojo {
    private List<String> errorMessage;
    private HttpStatus statusCode;
}
