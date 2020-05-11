package com.wms.entity;

import com.wms.entity.constant.Role;

import lombok.Data;

/**
 * @author chirag
 * @type Customer
 * @since Mar 19, 2020 5:46:52 PM
 */

@Data
public class Customer implements IRole {

	private Role name;

	public Customer() {
		this.name = Role.CUSTOMER;
	}

	@Override
	public String toString() {
		return this.name.toString();
	}
}
