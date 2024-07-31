package com.fcr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fcr.entity.CaseDetails;
import com.fcr.repository.CaseDetailsRepo;

@Service
public class CaseDetailsService {
	
	@Autowired
	CaseDetailsRepo caseDetailsRepo;
	
	public String insertcasedetails(@RequestBody CaseDetails caseDetails) {
		caseDetailsRepo.save(caseDetails);
		return "inserted";
	}
	
	public String updateCaseDetails(@RequestParam String childReviewId,@RequestParam String issueId,@RequestParam String trackIssueId,@RequestParam String headOfFcrAction,@RequestParam String caseStatus,@RequestParam String srCreditReview,@RequestParam String headOfFcr,@RequestParam String creditReview,@RequestParam String planningStage,@RequestParam String reviewId ) {
		
		caseDetailsRepo.updateAudit(childReviewId, issueId, trackIssueId, headOfFcrAction, caseStatus, srCreditReview, headOfFcr, creditReview,planningStage, reviewId);
		return "Updated case Details";
	}

	public List<CaseDetails> fetchCaseDetails(String reviewId) {
		List<CaseDetails> details =caseDetailsRepo.getcaseDetails(reviewId);
		return details;
	} 
	 
	

}
