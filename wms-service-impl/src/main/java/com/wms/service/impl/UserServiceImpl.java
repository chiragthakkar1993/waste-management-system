/**
 * UserServiceImpl.java
 *  
 */
package com.wms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wms.entity.User;
import com.wms.exception.EntityNotFoundException;
import com.wms.respository.IUserRepository;
import com.wms.service.IUserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chirag
 * @type UserServiceImpl
 * @since May 7, 2020
 */

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public Optional<Page<User>> findAll(Pageable pageable) {
		Page<User> users = this.userRepository.findAll(pageable);
		log.debug("total elements in Products = " + users.getTotalElements());
		log.debug("total pages for Products = " + users.getTotalPages());
		return Optional.ofNullable(users);
	}

	@Override
	public Optional<User> findById(String id) {
		return this.userRepository.findById(id);
	}

	@Override
	public Optional<User> findByName(String name) {
		return null;
	}

	@Override
	public Optional<User> create(User user) {
		return Optional.<User>ofNullable(this.userRepository.insert(user));
	}

	@Override
	public void delete(String id) {
		if (!this.userRepository.removeById(id))
			throw new EntityNotFoundException("Entity you want to remove doesn't exist");
	}

	public void deleteAll(List<User> users) {
		userRepository.deleteAll(users);
	}

	@Override
	public Optional<User> update(User user) {
		return Optional.<User>ofNullable(this.userRepository.save(user));
	}

}
