package com.wms.seeder;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.wms.entity.Customer;
import com.wms.entity.User;

/**
 * UserDataSeeder.java
 *  
 */

/**
 * @author chirag
 * @type UserDataSeeder
 * @since May 7, 2020
 */
@Component
public class UserDataSeeder {

	@Autowired
	private MongoTemplate mongoTemplate;

	@PostConstruct
	public void setup() {
		mongoTemplate.dropCollection(User.class);
		User chirag = User.builder().email("chirag.thakkar1993@gmail.com").firstName("chirag").lastName("Thakkar")
				.mobile("9727432368").role(new Customer()).build();
		User gaurav = User.builder().email("gaurav@gmail.com").firstName("gaurav").lastName("mittal")
				.mobile("1234567890").role(new Customer()).build();

		this.mongoTemplate.insertAll(Arrays.asList(chirag, gaurav));

	}
}
