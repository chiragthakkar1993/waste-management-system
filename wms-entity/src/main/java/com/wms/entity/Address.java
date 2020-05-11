/**
 * Address.java
 *  
 */
package com.wms.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author chirag
 * @type Address
 * @since May 7, 2020
 */

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
public class Address extends AbstractEntity {
	@Id
	private String id;
	private String houseNo;
	private String society;
	private String street;
	private String sector;
	private String block;
	private String ward;
	private String colony;
	@Field("address_type")
	private String addresstype;
	private Zone zone;
	private Location location;

}
