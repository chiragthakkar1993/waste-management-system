/**
 * DataGatherer.java
 *  
 */
package com.wms.entity;

import com.wms.entity.constant.Role;

import lombok.Data;

/**
 * @author chirag
 * @type DataGatherer
 * @since May 11, 2020
 */

@Data
public class Capturer implements IRole {
	private Role name;

	public Capturer() {
		this.name = Role.CAPTURER;
	}

	@Override
	public String toString() {
		return this.name.toString();
	}

}
