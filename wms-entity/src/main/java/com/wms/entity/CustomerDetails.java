/**
 * CustomerDetails.java
 *  
 */
package com.wms.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author chirag
 * @type CustomerDetails
 * @since May 11, 2020
 */

@Document(collection = "customer_details")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Builder
public class CustomerDetails {
	@Id
	private String id;
	private String firstname;
	private String lastname;
	private String email;
	private String mobile;

}
