/**
 * 
 */
package com.example.spring.validator.entity;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Sumit
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestEntityPojo {

	@NotBlank(message = "ID is Blank")
	private String id;
	@NotBlank(message = "Name is Blank")
	private String fname;
	@NotBlank(message = "Last Name is Blank")
	private String lname;
	
}
