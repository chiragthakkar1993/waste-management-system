/**
 * RestResponse.java
 *  
 */
package com.wms.constant;

/**
 * @author chirag
 * @type RestResponse
 * @since May 12, 2020
 */
public enum RestResponseStatus {
	SUCCESS("SUCCESS"), FAILED("FAILED"), PROCESSING("PROCESSING");

	private String strstatus;

	RestResponseStatus(String strRole) {
		this.strstatus = strRole;
	}

	@Override
	public String toString() {
		return this.strstatus;
	}

}
