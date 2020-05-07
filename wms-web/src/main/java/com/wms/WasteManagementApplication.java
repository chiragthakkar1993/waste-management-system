/**
 * WasteManagementApplication.java
 *  
 */
package com.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author chirag
 * @type WasteManagementApplication
 * @since May 1, 2020
 */

@SpringBootApplication(scanBasePackages = { "com.wms" })
@EnableMongoRepositories
public class WasteManagementApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(WasteManagementApplication.class, args);
	}

}