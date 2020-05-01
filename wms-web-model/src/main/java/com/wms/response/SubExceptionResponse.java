package com.wms.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author chirag
 * @type SubExceptionResponse
 * @since Apr 3, 2020
 */
@Getter
@Setter
public abstract class SubExceptionResponse {
	private String message;
}
