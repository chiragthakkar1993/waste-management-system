package com.wms.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wms.constant.RestResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Component
@PropertySource(value = "classpath:rest.properties", ignoreResourceNotFound = true)
public class GenericExceptionResponse {

	@Value("${wms.api.version}")
	@Setter
	private String apiversion;
	private HttpStatus http_status;
	private RestResponseStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private String debugMessage;
	private String path;
	@Setter
	private List<SubExceptionResponse> errors;

	private GenericExceptionResponse() {
		timestamp = LocalDateTime.now();

	}

	public GenericExceptionResponse(HttpStatus http_status, String message, String path, Throwable ex) {
		this();
		this.path = path;
		this.http_status = http_status;
		this.status = RestResponseStatus.FAILED;
		this.message = message;
		this.debugMessage = ex.toString();
	}

	public void addSubExceptionResponse(SubExceptionResponse subExceptionResponse) {
		if (errors == null) {
			errors = new ArrayList<>();
		}
		errors.add(subExceptionResponse);
	}

}
