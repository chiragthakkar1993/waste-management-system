/**
 * IAddressService.java
 *  
 */
package com.wms.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wms.entity.Address;
import com.wms.entity.User;

/**
 * @author chirag
 * @type IAddressService
 * @since May 11, 2020
 */
public interface IAddressService {

	/**
	 * @param address
	 * @return
	 */
	public Optional<Address> create(Address address);

}
