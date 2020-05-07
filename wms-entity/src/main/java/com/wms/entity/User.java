/**
 * User.java
 *  
 */
package com.wms.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

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
@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class User extends AbstractEntity {
	private String id;
	@NotEmpty
	@Size(min = 2, max = 100)
	private String name;
	@NotEmpty
	private String mobile;
	@Email
	private String email;

}
