/**
 * Subscription.java
 *  
 */
package com.wms.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author chirag
 * @type Subscription
 * @since May 7, 2020
 */

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Builder
public class Subscription extends AbstractEntity {

	@Id
	@EqualsAndHashCode.Include
	private String id;
	private Address address;
	private User user;
	@JsonProperty("active")
	private Boolean isActive;

}
