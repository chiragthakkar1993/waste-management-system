/**
 * UserController.java
 *  
 */
package com.wms.rest.web.controller.v1;

import static com.wms.entity.factory.RoleFactory.getRole;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wms.dto.UserDto;
import com.wms.entity.User;
import com.wms.rest.assembler.UserAssembler;
import com.wms.service.IUserService;

import io.swagger.annotations.Api;

/**
 * @author chirag
 * @type UserController
 * @since May 7, 2020
 */

@RestController
@RequestMapping("/users")
@CrossOrigin
@Api(value = "User Service", tags = { "User Service" })
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private PagedResourcesAssembler<User> pageAssembler;

	@Autowired
	private UserAssembler userAssembler;

	/**
	 * @param pageable
	 * @return
	 */
	@GetMapping()
	public ResponseEntity<PagedModel<UserDto>> findAll(
			@PageableDefault(direction = Direction.ASC, page = 0, size = 5, sort = { "id" }) Pageable pageable) {
		ResponseEntity<PagedModel<UserDto>> response = this.userService.findAll(pageable)
				.filter(result -> !result.isEmpty())
				.map(result -> new ResponseEntity<PagedModel<UserDto>>(pageAssembler.toModel(result, userAssembler),
						HttpStatus.OK))
				.orElse(new ResponseEntity<PagedModel<UserDto>>(HttpStatus.NO_CONTENT));
		return response;
	}

	/**
	 * @param userDto
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody UserDto userDto) {

		User user = User.builder().firstName(userDto.getFirstName()).lastName(userDto.getLastName())
				.userName(userDto.getUsername()).password(userDto.getPassword()).email(userDto.getEmail())
				.mobile(userDto.getMobile()).dob(userDto.getDob()).isSubscribed(userDto.isSubscribed())
				.role(getRole(userDto.getRole())).build();

		User savedUser = this.userService.create(user).get();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable String id) {
		UserDto userDto = userAssembler
				.toModel(this.userService.findById(id).orElseThrow(ResourceNotFoundException::new));
		return ResponseEntity.ok(userDto);

	}

	/**
	 * @param userDto
	 * @return
	 */
	@PutMapping
	public ResponseEntity<Void> update(@Valid @RequestBody UserDto userDto) {

		User user = User.builder().id(userDto.getId()).firstName(userDto.getFirstName()).lastName(userDto.getLastName())
				.userName(userDto.getUsername()).password(userDto.getPassword()).email(userDto.getEmail())
				.mobile(userDto.getMobile()).dob(userDto.getDob()).isSubscribed(userDto.isSubscribed())
				.role(getRole(userDto.getRole())).build();

		User savedUser = this.userService.update(user).get();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	/**
	 * @param id
	 */
	@DeleteMapping
	public void delete(@PathVariable String id) {
		this.userService.delete(id);
	}

	/**
	 * @param users
	 */
	public void deleteAll(@RequestBody List<User> users) {
		this.userService.deleteAll(users);
	}
}
