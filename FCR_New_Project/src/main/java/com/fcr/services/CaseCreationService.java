package com.fcr.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcr.dto.CaseCreation;
import com.fcr.entity.TaskDetails;
import com.fcr.repository.FcrRepository;

@Service
public class CaseCreationService {
	
	@Autowired
	FcrRepository fcrRepository;

	public String createCase(CaseCreation caseCreation) {
		String reviewId="FCR-";
				
	TaskDetails details	= TaskDetails.builder().reviewId(caseCreation.getReviewId())
		.division(caseCreation.getDivision())
		.portfolio(caseCreation.getPortfolio())
		.assignTo("SR Credit Reviewer")
		.taskStatus("Created")
		.build();
		
		try{
		fcrRepository.save(details);
		return "Case Creation Success";
		}catch(Exception e) {
			return "Case Creation Failed";
		}
		
		
	}

}
