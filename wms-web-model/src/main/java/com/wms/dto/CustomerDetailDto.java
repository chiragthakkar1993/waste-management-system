/**
 * CustomerDetailDto.java
 *  
 */
package com.wms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author chirag
 * @type CustomerDetailDto
 * @since May 11, 2020
 */

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Builder
@Getter
public class CustomerDetailDto {
	private String id;
	@Size(min = 2, max = 50)
	private String firstname;
	@Size(min = 2, max = 50)
	private String lastname;
	private String email;
	@NotBlank
	private String mobile;
}
