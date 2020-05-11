/**
 * UserCustomRepositoryImpl.java
 *  
 */
package com.wms.respository.custom.impl;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.wms.entity.User;
import com.wms.respository.custom.IUserCustomRepository;

/**
 * @author chirag
 * @type UserCustomRepositoryImpl
 * @since May 11, 2020
 */
public class UserCustomRepositoryImpl implements IUserCustomRepository {

	private MongoTemplate mongoTemplate;

	@Override
	public boolean removeById(String id) {
		Query deleteByIdQuery = new Query(Criteria.where("id").is(id));
		long deletedCount = this.mongoTemplate.remove(deleteByIdQuery, User.class).getDeletedCount();
		return deletedCount != 0;
	}
}
