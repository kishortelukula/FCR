package com.fcr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fcr.entity.CaseDetails;

import jakarta.transaction.Transactional;

@Repository
public interface CaseDetailsRepo extends JpaRepository<CaseDetails, Long> {

	@Transactional
	@Modifying
	@Query("UPDATE CaseDetails c SET c.childReviewId = :childReviewId ,c.issueId =:issueId,c.trackIssueId=:trackIssueId,c.headOfFcrAction=:headOfFcrAction,c.caseStatus=:caseStatus,c.srCreditReview=:srCreditReview,c.headOfFcr=:headOfFcr,c.creditReview=:creditReview, WHERE c.reviewId = :reviewId")
	public void updateAudit(String childReviewId, String issueId, String trackIssueId, String headOfFcrAction,
			String caseStatus, String srCreditReview, String headOfFcr, String creditReview,
			String reviewId);

}
