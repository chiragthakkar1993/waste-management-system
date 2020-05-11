/**
 * CapturerService.java
 *  
 */
package com.wms.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.entity.Address;
import com.wms.entity.CustomerDetails;
import com.wms.service.IAddressService;
import com.wms.service.ICapturerService;
import com.wms.service.ICustomerService;

/**
 * @author chirag
 * @type CapturerService
 * @since May 12, 2020
 */

@Service
public class CapturerService implements ICapturerService {

	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IAddressService addressService;

	@Override
	public Optional<CustomerDetails> registerCustomer(CustomerDetails customer) {
		return this.customerService.create(customer);
	}

	@Override
	public Optional<Address> registerAddress(Address address) {
		return this.addressService.create(address);
	}

}
