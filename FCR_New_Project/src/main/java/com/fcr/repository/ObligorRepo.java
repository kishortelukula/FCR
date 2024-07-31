package com.fcr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fcr.entity.FcrObligor;

import jakarta.transaction.Transactional;
@Repository
public interface ObligorRepo extends JpaRepository<FcrObligor, Long>{
	
	@Query("select a from FcrObligor as a where a.reviewId=:reviewId")
	public List<FcrObligor> fetchObligorById(String reviewId);

		
	@Transactional
	@Modifying
	@Query("update FcrObligor f set f.reviewStatus=:reviewStatus where f.reviewId=:reviewId and f.childReviewId=:childReview")
	public String updateObligor(String reviewStatus,String reviewId,String childReview);
}
