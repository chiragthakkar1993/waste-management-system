/**
 * ICapturerRepository.java
 *  
 */
package com.wms.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wms.entity.CustomerDetails;

/**
 * @author chirag
 * @type ICapturerRepository
 * @since May 12, 2020
 */

@Repository
public interface ICustomerRepository extends MongoRepository<CustomerDetails, String> {

}
