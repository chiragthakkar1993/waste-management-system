/**
 * CapturerController.java
 *  
 */
package com.wms.rest.web.controller.v1;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wms.constant.RestResponseStatus;
import com.wms.dto.AddressDto;
import com.wms.dto.CustomerDetailDto;
import com.wms.entity.Address;
import com.wms.entity.CustomerDetails;
import com.wms.entity.Location;
import com.wms.response.RestResponse;
import com.wms.service.ICapturerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author chirag
 * @type CapturerController
 * @since May 12, 2020
 */

@RequestMapping("/capturers")
@RestController
@CrossOrigin
@Api(value = "Capturer Service", tags = { "Capturer Service" })
public class CapturerController {

	@Autowired
	private ICapturerService capturerService;

	/**
	 * @param addressDto
	 */
	@PostMapping("/addresses")
	@ApiOperation(value = "registers address")
	public ResponseEntity<RestResponse<Address>> registerAddress(@Valid @RequestBody AddressDto addressDto) {

		Location location = Location.builder().latitude(addressDto.getLatitude()).longitude(addressDto.getLongitude())
				.build();

		Address address = Address.builder().houseNo(addressDto.getHouseNo()).society(addressDto.getSociety())
				.street(addressDto.getStreet()).sector(addressDto.getSector()).block(addressDto.getBlock())
				.ward(addressDto.getWard()).addresstype(addressDto.getAddressType()).location(location).build();

		Address savedAddress = this.capturerService.registerAddress(address).get();
		URI location_uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedAddress.getId()).toUri();

		RestResponse<Address> restResponse = RestResponse.<Address>builder()
				.message(HttpStatus.CREATED.getReasonPhrase()).status(RestResponseStatus.SUCCESS.toString()).build();
		return ResponseEntity.created(location_uri).body(restResponse);
	}

	@PostMapping("/customers")
	@ApiOperation(value = "registers customer")
	public ResponseEntity<RestResponse<CustomerDetails>> registerCustomer(
			@Valid @RequestBody CustomerDetailDto customerDto) {

		CustomerDetails customer = CustomerDetails.builder().firstname(customerDto.getFirstname())
				.lastname(customerDto.getLastname()).mobile(customerDto.getMobile()).email(customerDto.getEmail())
				.build();

		CustomerDetails savedCustomer = this.capturerService.registerCustomer(customer).get();
		URI location_uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCustomer.getId()).toUri();

		RestResponse<CustomerDetails> restResponse = RestResponse.<CustomerDetails>builder()
				.message(HttpStatus.CREATED.getReasonPhrase()).status(RestResponseStatus.SUCCESS.toString()).build();

		return ResponseEntity.created(location_uri).body(restResponse);

	}

}
