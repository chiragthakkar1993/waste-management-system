/**
 * RoleFactory.java
 *  
 */
package com.wms.entity.factory;

import com.wms.entity.Capturer;
import com.wms.entity.Collector;
import com.wms.entity.Customer;
import com.wms.entity.IRole;
import com.wms.entity.Supervisor;
import com.wms.entity.constant.Role;

/**
 * @author chirag
 * @type RoleFactory
 * @since May 11, 2020
 */
public class RoleFactory {
	public static IRole getRole(String role) {
		Role enum_Role = Role.valueOf(role.toUpperCase());
		switch (enum_Role) {
		case COLLECTOR:
			return new Collector();
		case CUSTOMER:
			return new Customer();
		case CAPTURER:
			return new Capturer();
		case SUPERVISOR:
			return new Supervisor();
		default:
			return null;
		}
	}

}
