/**
 * AbstractEntity.java
 *  
 */
package com.wms.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

/**
 * @author chirag
 * @type AbstractEntity
 * @since May 6, 2020
 */

@Getter
@JsonIgnoreProperties(value = { "createdBy", "createdDate", "updatedBy", "updatedDate" })
public abstract class AbstractEntity {
	@CreatedBy
	private String createdBy;
	@LastModifiedBy
	private String updatedBy;
	@CreatedDate
	private String createdDate;
	@LastModifiedDate
	private String updatedDate;
}
