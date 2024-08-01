package com.fcr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcr.entity.FcrResponseRemedations;
import com.fcr.repository.ResponseRemedationRepo;

@Service
public class ResponseRemedationService {
	@Autowired
	ResponseRemedationRepo remedationRepo;
	
	public String insertResponseRemedation(FcrResponseRemedations fcrResponseRemedation) {
		remedationRepo.save(fcrResponseRemedation);
		return "ResponseRemedation Inserted";
	}
	
	public List<FcrResponseRemedations> fetchResponseRemedation( String reviewId) {
		return remedationRepo.fetchResponseRemedation(reviewId);
		
	}
	
	public String updateResponseRemedation(String reviewStatus,String reviewId,String childReview) {
		remedationRepo.updateResponseRemedation(reviewStatus, reviewId, childReview);
		return "ResponseRemedation Updated Succesfully";
		
	}
}
