package com.example.pojo;

import javax.validation.constraints.NotBlank;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RequestPojo {
	
	@NotBlank(message = "ID Cannot be blank")
	private String Id;
	@NotBlank(message = " Request ID cannot be blank")
	private String requestId;
	@NotBlank(message = " Name cannot be blank")
	private String name;
	@NotBlank(message = " CorrelationId ID cannot be blank")
	private String CorrelationId;
	


}
