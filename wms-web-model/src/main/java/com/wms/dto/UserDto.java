/**
 * UserDto.java
 *  
 */
package com.wms.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author chirag
 * @type UserDto
 * @since May 11, 2020
 */

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Builder
@Getter
public class UserDto extends RepresentationModel<UserDto> {

	@EqualsAndHashCode.Include
	private String id;
	@NotEmpty
	private String mobile;
	@Email
	private String email;
	private String username;
	private String password;
	@JsonProperty("first_name")
	@Size(min = 2, max = 50)
	private String firstName;
	@JsonProperty("last_name")
	@Size(min = 2, max = 50)
	private String lastName;
	private Date dob;
	@JsonProperty("subscribed")
	private boolean isSubscribed;
	private String role;
}
