/**
 * User.java
 *  
 */
package com.wms.entity;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author chirag
 * @type User
 * @since May 6, 2020
 */

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Builder
public class User extends AbstractEntity {
	@Id
	@EqualsAndHashCode.Include
	private String id;
	private String mobile;
	private String email;
	@Field("username")
	private String userName;
	@Field("password")
	private String password;
	@Field("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	private Date dob;
	@JsonProperty("subscribed")
	@Field("subscribed")
	private boolean isSubscribed;
	private IRole role;
}
