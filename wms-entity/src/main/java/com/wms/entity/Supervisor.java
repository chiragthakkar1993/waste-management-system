/**
 * Supervisor.java
 *  
 */
package com.wms.entity;

import com.wms.entity.constant.Role;

import lombok.Data;

/**
 * @author chirag
 * @type Supervisor
 * @since May 10, 2020
 */

@Data
public class Supervisor implements IRole {
	private Role name;

	public Supervisor() {
		this.name = Role.SUPERVISOR;
	}

	@Override
	public String toString() {
		return this.name.toString();
	}

}
