/**
 * ComplaintResolution.java
 *  
 */
package com.wms.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author chirag
 * @type ComplaintResolution
 * @since May 7, 2020
 */

@Document
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComplaintResolution extends AbstractEntity {
	private String id;
	private String remarks;
	private String status;
	private String tat;

}
