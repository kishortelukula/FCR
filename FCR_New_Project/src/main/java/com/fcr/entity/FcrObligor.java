package com.fcr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FcrObligor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long obligorId;//OBLIGOR_ID;
	private String reviewId;//REVIEW_ID;
	private String obligorName;//OBLIGOR_NAME;
	private String obligorCifId;//OBLIGOR_CIF_ID;
	private String obligorPremId;//OBLIGOR_PREM_ID;
	private String groupName;//GROUP_NAME;
	private String createdBy;//CREATED_BY;
	private String createdOn;//CREATED_ON;
	private String modifiedBy;//MODIFIED_BY;
	private String modifiedOn;//MODIFIED_ON;
	private String reviewStatus;//REVIEW_STATUS;
	private String division;//DIVISION;
	private String observation;//OBSERVATION;
	private String childReviewId;//CHILD_REVIEWID;
	

}
