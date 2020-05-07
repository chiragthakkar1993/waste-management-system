/**
 * SampleController.java
 *  
 */
package com.wms.rest.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chirag
 * @type SampleController
 * @since May 7, 2020
 */
@RestController
@RequestMapping("/sample")
public class SampleController {

	@GetMapping
	public String helloWorld() {
		return "Hello World";
	}
}
