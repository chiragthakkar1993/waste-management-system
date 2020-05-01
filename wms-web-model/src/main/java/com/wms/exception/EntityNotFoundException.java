package com.wms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "requested value doesn't exist")
public class EntityNotFoundException extends RuntimeException {
	/**
	 * generated unique serialVersionId
	 */
	private static final long serialVersionUID = 1204265327210834043L;

	/**
	 * default constructor to set the default message
	 * 
	 */	
	public EntityNotFoundException() {
		super("requested entity doesn't exist");
	}

	public EntityNotFoundException(String message) {
		super(message);
	}
}
