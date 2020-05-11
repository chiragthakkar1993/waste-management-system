/**
 * IUserService.java
 *  
 */
package com.wms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wms.entity.User;

/**
 * @author chirag
 * @type IUserService
 * @since May 7, 2020
 */

public interface IUserService {

	/**
	 * @return
	 */
	public Optional<Page<User>> findAll(Pageable pageable);

	/**
	 * @param id
	 * @return
	 */
	public Optional<User> findById(String id);

	/**
	 * @param name
	 * @return
	 */
	public Optional<User> findByName(String name);

	/**
	 * @param user
	 * @return
	 */
	public Optional<User> create(User user);

	/**
	 * @param id
	 */
	public void delete(String id);

	/**
	 * @param users
	 */
	public void deleteAll(List<User> users);

	/**
	 * @param user
	 * @return
	 */
	public Optional<User> update(User user);

}
