/**
 * WasteManagementApplication.java
 *  
 */
package com.wms.rest.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chirag
 * @type WasteManagementApplication
 * @since May 1, 2020
 */

@SpringBootApplication(scanBasePackages = "com.wms")
public class WasteManagementApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(WasteManagementApplication.class, args);
	}

}