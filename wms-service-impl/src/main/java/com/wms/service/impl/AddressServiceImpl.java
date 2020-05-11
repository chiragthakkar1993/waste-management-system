/**
 * AddressServiceImpl.java
 *  
 */
package com.wms.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.entity.Address;
import com.wms.respository.IAddressRepository;
import com.wms.service.IAddressService;

/**
 * @author chirag
 * @type AddressServiceImpl
 * @since May 12, 2020
 */

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private IAddressRepository addressRepository;

	@Override
	public Optional<Address> create(Address address) {
		return Optional.<Address>ofNullable(this.addressRepository.insert(address));
	}

}
