/**
 * RestResponse.java
 *  
 */
package com.wms.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chirag
 * @param <T>
 * @type RestResponse
 * @since May 12, 2020
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse<T> {
	private String message;
	private String status;
	private T data;
}
