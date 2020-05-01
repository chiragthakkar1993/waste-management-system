/**
 * RestExceptionHandler.java
 *  
 */
package com.wms.rest.web.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wms.exception.EntityNotFoundException;
import com.wms.response.GenericExceptionResponse;
import com.wms.response.ValidationSubExceptionResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chirag
 * @type RestExceptionHandler
 * @since Apr 4, 2020
 */

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private AutowireCapableBeanFactory autowireCapableBeanFactory;

	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleResourceNotFoundException(EntityNotFoundException ex, WebRequest request,
			HttpServletRequest httpRequest) {

		GenericExceptionResponse exceptionResponse = new GenericExceptionResponse(HttpStatus.NOT_FOUND, ex.getMessage(),
				httpRequest.getRequestURI(), ex);
		autowireCapableBeanFactory.autowireBean(exceptionResponse);
		log.error(request.getDescription(false), ex);
		return this.buiResponseEntity(exceptionResponse);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		StringBuilder sbURI = new StringBuilder(request.getDescription(false));
		String strURI = sbURI.substring(sbURI.indexOf("=") + 1).toString();

		GenericExceptionResponse exceptionResponse = new GenericExceptionResponse(HttpStatus.BAD_REQUEST,
				"Validation Error(s)", strURI, ex);
		autowireCapableBeanFactory.autowireBean(exceptionResponse);
		ValidationSubExceptionResponse validationErrorResponse = new ValidationSubExceptionResponse();
		autowireCapableBeanFactory.autowireBean(validationErrorResponse);
		ex.getBindingResult().getFieldErrors().forEach(e -> {
			validationErrorResponse.setObject(e.getObjectName());
			validationErrorResponse.setField(e.getField());
			validationErrorResponse.setRejectedValue(e.getRejectedValue());
			validationErrorResponse.setMessage(e.getDefaultMessage());

		});
		exceptionResponse.addSubExceptionResponse(validationErrorResponse);
		try {
			log.error(request.getDescription(false) + System.lineSeparator()
					+ this.objectMapper.writeValueAsString(exceptionResponse), ex);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.buiResponseEntity(exceptionResponse);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleResourceNotFoundException(Exception ex, WebRequest request,
			HttpServletRequest httpRequest) {

		GenericExceptionResponse exceptionResponse = new GenericExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR,
				ex.getLocalizedMessage(), httpRequest.getRequestURI(), ex);
		log.error(request.getDescription(false), ex);
		return this.buiResponseEntity(exceptionResponse);
	}

	private ResponseEntity<Object> buiResponseEntity(GenericExceptionResponse genericResponse) {
		return new ResponseEntity<Object>(genericResponse, genericResponse.getStatus());
	}

}
