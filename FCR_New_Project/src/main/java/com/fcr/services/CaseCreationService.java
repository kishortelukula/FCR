package com.fcr.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

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
		String fixedString = "FCR-";

		String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));

		Random random = new Random();
		int randomNumber = random.nextInt(900) + 100;

		String reviewId = fixedString + currentDate + "-" + randomNumber;

		System.out.println(reviewId);

		TaskDetails details = TaskDetails.builder().reviewId(reviewId).division(caseCreation.getDivision())
				.portfolio(caseCreation.getPortfolio()).assignTo("SR Credit Reviewer").taskStatus("Created").build();

		try {
			fcrRepository.save(details);
			return "Case Creation Success";
		} catch (Exception e) {
			return "Case Creation Failed";
		}

	}

}
