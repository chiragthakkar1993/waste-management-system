/**
 * CollectorAddress.java
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
 * @type CollectorAddress
 * @since May 10, 2020
 */
@Document
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CollectorAddress extends AbstractEntity {
	@Id
	private String id;
	private User user;
	private Address address;
}
