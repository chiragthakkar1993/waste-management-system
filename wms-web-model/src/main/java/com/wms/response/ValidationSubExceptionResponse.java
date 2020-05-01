/**
 * 
 */
package com.wms.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author chirag
 * @type ValidationSubExceptionResponse
 * @since Apr 3, 2020
 */

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ValidationSubExceptionResponse extends SubExceptionResponse {

	private String object;
	private String field;
	private Object rejectedValue;

}
