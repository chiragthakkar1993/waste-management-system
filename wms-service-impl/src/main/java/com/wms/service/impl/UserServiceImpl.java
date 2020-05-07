/**
 * UserServiceImpl.java
 *  
 */
package com.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.entity.User;
import com.wms.respository.IUserRepository;
import com.wms.service.IUserService;

/**
 * @author chirag
 * @type UserServiceImpl
 * @since May 7, 2020
 */

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}
}
