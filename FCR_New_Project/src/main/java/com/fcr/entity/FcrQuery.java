package com.fcr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FcrQuery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long slNo;
	private String querySeq;
	private String query;
	private String createdOn;
	private String createdBy;
	private String assignedTo;
	private String response;
	private String responseBy;
	private String responseOn;
	private String childReviewId;
	private String reviewId;
	private String obligorCifId;
	private String updatedOn;
}
