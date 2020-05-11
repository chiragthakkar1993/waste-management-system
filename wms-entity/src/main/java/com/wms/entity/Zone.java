/**
 * Zone.java
 *  
 */
package com.wms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author chirag
 * @type Zone
 * @since May 10, 2020
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Zone {
	private String id;
	private String pincode;
	private City city;
}
