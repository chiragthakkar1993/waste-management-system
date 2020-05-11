/**
 * Location.java
 *  
 */
package com.wms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chirag
 * @type Location
 * @since May 7, 2020
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {
	private double latitude;
	private double longitude;

}
