/**
 * Roles.java
 *  
 */
package com.wms.entity.constant;

/**
 * @author chirag
 * @type Roles
 * @since May 10, 2020
 */
public enum Role {
	CUSTOMER("Customer"), SUPERVISOR("Supervisor"), MANAGER("Manager"), COLLECTOR("Collector"), CAPTURER("Capturer");

	private String strRole;

	Role(String strRole) {
		this.strRole = strRole;
	}

	@Override
	public String toString() {
		return this.strRole;
	}

}
