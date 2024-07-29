package com.fcr.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcr.dto.CaseCreation;
import com.fcr.entity.AuditTrail;
import com.fcr.entity.TaskDetails;
import com.fcr.repository.FcrRepository;

@Service
public class CaseCreationService {

	@Autowired
	FcrRepository fcrRepository;

	@Autowired
	public AuditService auditService;

	public String createCase(CaseCreation caseCreation) {
		String inTime = LocalDate.now().toString();

		String fixedString = "FCR-";
		String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
		
		Random random = new Random();
		int randomNumber = random.nextInt(900) + 100;

		String reviewId = fixedString + currentDate + "-" + randomNumber;

		System.out.println(reviewId);

		TaskDetails details = TaskDetails.builder().reviewId(reviewId).division(caseCreation.getDivision())
				.portfolio(caseCreation.getPortfolio()).assignTo("SR Credit Reviewer").taskStatus("Created").role("SR Credit Reviewer").build();
//Auditing 
		AuditTrail trail = AuditTrail.builder().reviewId(reviewId).actionedBy("").activityLevel("SR Credit Reviewer")
				.currentAction("CaseCreation").inTime(inTime).outTime(LocalDateTime.now().toString()).build();
		auditService.insertAudit(trail);

		try {
			fcrRepository.save(details);
			return "Case Creation Success with Review Id:" + details.getReviewId();

		} catch (Exception e) {
			return "Case Creation Failed";
		}

	}

	public void updateCase(String role ,String assignTo,String reviewId) {
		fcrRepository.updateCase(role,assignTo,reviewId);
		
	}

}
