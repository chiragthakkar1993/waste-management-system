/**
 * Collector.java
 *  
 */
package com.wms.entity;

import com.wms.entity.constant.Role;

import lombok.Data;

/**
 * @author chirag
 * @type Collector
 * @since May 7, 2020
 */

@Data
public class Collector implements IRole {
	private Role name;

	public Collector() {
		this.name = Role.COLLECTOR;
	}

	@Override
	public String toString() {
		return this.name.toString();
	}
}
