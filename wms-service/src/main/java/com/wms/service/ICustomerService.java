/**
 * ICustomerService.java
 *  
 */
package com.wms.service;

import java.util.Optional;

import com.wms.entity.CustomerDetails;

/**
 * @author chirag
 * @type ICustomerService
 * @since May 12, 2020
 */
public interface ICustomerService {

	/**
	 * @param customer
	 * @return
	 */
	Optional<CustomerDetails> create(CustomerDetails customer);

}
