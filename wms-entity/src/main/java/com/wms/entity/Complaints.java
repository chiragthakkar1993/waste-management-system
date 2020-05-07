/**
 * Complaints.java
 *  
 */
package com.wms.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author chirag
 * @type Complaints
 * @since May 7, 2020
 */

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Complaints extends AbstractEntity {
	@Id
	private String id;
	@JsonProperty("ticket_no")
	private String ticketNo;
	@JsonProperty("type")
	private String complaintType;
	@DBRef
	private Subscription subscription;
	@DBRef
	private ComplaintResolution resoultion;

}
