/**
 * AddressDto.java
 *  
 */
package com.wms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author chirag
 * @type AddressDto
 * @since May 12, 2020
 */

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Builder
@Getter
public class AddressDto {
	private String id;
	@JsonProperty("house_no")
	private String houseNo;
	private String society;
	private String street;
	private String sector;
	private String block;
	private String ward;
	private String colony;
	@JsonProperty("address_type")
	private String addressType;
	private double latitude;
	private double longitude;

}
