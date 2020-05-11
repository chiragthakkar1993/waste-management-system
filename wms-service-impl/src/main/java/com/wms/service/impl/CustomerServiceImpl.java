/**
 * CustomerServiceImpl.java
 *  
 */
package com.wms.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.entity.CustomerDetails;
import com.wms.respository.ICustomerRepository;
import com.wms.service.ICustomerService;

/**
 * @author chirag
 * @type CustomerServiceImpl
 * @since May 12, 2020
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public Optional<CustomerDetails> create(CustomerDetails customer) {
		return Optional.<CustomerDetails>ofNullable(this.customerRepository.insert(customer));
	}

}
