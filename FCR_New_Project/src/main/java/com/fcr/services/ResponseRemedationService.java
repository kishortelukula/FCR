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
	
	public String deleteResponseRemedation(String reviewId,String childReviewId) {
		remedationRepo.deleteByReviewIdAndChildReviewId(reviewId, childReviewId);
		return "Deleted Successfully";
	}
	
	public String updateQuery(String query,String reviewId,String childReviewId) {
		remedationRepo.updateFcrResponseRemedations(query, reviewId, childReviewId);
		return "Query Updated Succesfully";
		
	}
}
