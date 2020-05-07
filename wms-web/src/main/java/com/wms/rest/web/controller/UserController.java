/**
 * UserController.java
 *  
 */
package com.wms.rest.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wms.entity.User;
import com.wms.service.IUserService;

/**
 * @author chirag
 * @type UserController
 * @since May 7, 2020
 */

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll() {
		List<User> users = this.userService.findAll();
		return users;
	}
}
