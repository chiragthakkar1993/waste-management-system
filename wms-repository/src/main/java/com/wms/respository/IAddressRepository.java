/**
 * IAddressService.java
 *  
 */
package com.wms.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wms.entity.Address;

/**
 * @author chirag
 * @type IAddressService
 * @since May 11, 2020
 */

@Repository
public interface IAddressRepository extends MongoRepository<Address, String> {

}
