/**
 * IUserService.java
 *  
 */
package com.wms.service;

import java.util.List;

import com.wms.entity.User;

/**
 * @author chirag
 * @type IUserService
 * @since May 7, 2020
 */

public interface IUserService {
	public List<User> findAll();
}
