/**
 * UserRepository.java
 *  
 */
package com.wms.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wms.entity.User;
import com.wms.respository.custom.IUserCustomRepository;

/**
 * @author chirag
 * @type UserRepository
 * @since May 7, 2020
 */

@Repository
public interface IUserRepository extends IUserCustomRepository, MongoRepository<User, String> {

}
