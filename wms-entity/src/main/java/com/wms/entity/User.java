/**
 * User.java
 *  
 */
package com.wms.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author chirag
 * @type User
 * @since May 6, 2020
 */

public abstract class User extends AbstractEntity {
	private String id;
	@NotEmpty
	@Size(min = 2, max = 100)
	private String name;
	@NotEmpty
	private String mobile;
	@Email
	private String email;

}
