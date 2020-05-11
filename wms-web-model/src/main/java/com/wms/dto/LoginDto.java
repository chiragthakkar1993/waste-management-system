/**
 * LoginDto.java
 *  
 */
package com.wms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author chirag
 * @type LoginDto
 * @since May 11, 2020
 */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LoginDto {
	private String username;
	private String email;
	private String password;

}
