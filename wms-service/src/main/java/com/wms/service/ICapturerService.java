/**
 * ICapturerService.java
 *  
 */
package com.wms.service;

import java.util.Optional;

import com.wms.entity.Address;
import com.wms.entity.CustomerDetails;

/**
 * @author chirag
 * @type ICapturerService
 * @since May 11, 2020
 */
public interface ICapturerService {

	public Optional<CustomerDetails> registerCustomer(CustomerDetails customer);

	public Optional<Address> registerAddress(Address address);

}
