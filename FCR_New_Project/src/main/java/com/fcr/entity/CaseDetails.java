package com.fcr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CaseDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long caseId;
	private String reviewId;
	private String division;
	private String portfolio;
	private String childReviewId;
	private String issueId;
	private String trackIssueId;
	private String headOfFcrAction;
	private String caseStatus;
	private String srCreditReview;
	private String headOfFcr;
	private String creditReview;
}
