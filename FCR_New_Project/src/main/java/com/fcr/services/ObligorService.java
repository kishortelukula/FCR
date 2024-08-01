package com.fcr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fcr.entity.FcrObligor;
import com.fcr.repository.ObligorRepo;
import com.fcr.repository.ResponseRemedationRepo;

@Service
public class ObligorService {
	
	@Autowired
	ObligorRepo obligorRepo;
	
	@Autowired
	ResponseRemedationRepo remedationRepo;
	
	public String insertObligor(FcrObligor obligor) {
		obligorRepo.save(obligor);
		return "Obligor Inserted";
	}
	
	public List<FcrObligor> fetchObligor( String reviewId) {
		return obligorRepo.fetchObligorById(reviewId);
		
	}
	
	public String updateObligor(String reviewStatus,String reviewId,String childReview) {
		obligorRepo.updateObligor(reviewStatus, reviewId, childReview);
		return "Obligor Updated Succesfully";
		
	}
	
	public String deleteObligor(String reviewId,String childReviewId) {
		obligorRepo.deleteObligor(reviewId, childReviewId);
		remedationRepo.deleteByReviewIdAndChildReviewId(reviewId, childReviewId);
		return "Obligor Deleted Successfully";
		
	}
	
	public String updateObservation(String observation,String reviewId,String childReviewId) {
		obligorRepo.updateObservation(observation, reviewId, childReviewId);
		return "Observation Updated Succesfully";
		
	}
}
