package com.wms.entity;

import java.util.Date;

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
 * @type Customer
 * @since Mar 19, 2020 5:46:52 PM
 */

@Document
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Customer extends AbstractEntity {

	@Id
	@EqualsAndHashCode.Include
	private String id;
	@Field("uname")
	@JsonProperty("uname")
	private String userName;
	private String email;
	@Field("pwd")
	@JsonProperty("pwd")
	private String password;
	@Field("fname")
	@JsonProperty("fname")
	private String firstName;
	@Field("lname")
	@JsonProperty("lname")
	private String lastName;
	private Date dob;

}
