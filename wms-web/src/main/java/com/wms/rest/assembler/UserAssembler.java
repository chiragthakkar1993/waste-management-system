/**
 * UserAssembler.java
 *  
 */
package com.wms.rest.assembler;

import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.wms.dto.UserDto;
import com.wms.entity.User;
import com.wms.rest.web.controller.v1.UserController;

/**
 * @author chirag
 * @type UserAssembler
 * @since Apr 16, 2020
 */

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<User, UserDto> {

	/**
	 * @param controllerClass
	 * @param resourceType
	 * @paramO
	 */
	public UserAssembler() {
		super(UserController.class, UserDto.class);
	}

	@Override
	public UserDto toModel(User entity) {

		Link selfLink = new Link(MvcUriComponentsBuilder.fromController(UserController.class).path("/{id}")
				.buildAndExpand(entity.getId()).toUriString(), IanaLinkRelations.SELF);
		UserDto userDto = UserDto.builder().firstName(entity.getFirstName()).lastName(entity.getLastName())
				.username(entity.getUserName()).password(entity.getPassword()).email(entity.getEmail())
				.mobile(entity.getMobile()).dob(entity.getDob()).isSubscribed(entity.isSubscribed())
				.role(entity.getRole().toString()).build();
		userDto.add(selfLink);

		return userDto;
	}

}
