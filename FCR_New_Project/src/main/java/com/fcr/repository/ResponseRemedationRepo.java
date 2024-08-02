package com.fcr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fcr.entity.FcrResponseRemedations;

import jakarta.transaction.Transactional;

@Repository
public interface ResponseRemedationRepo extends JpaRepository<FcrResponseRemedations, Long> {

	@Query("select a from FcrResponseRemedations as a where a.reviewId=:reviewId")
	public List<FcrResponseRemedations> fetchResponseRemedation(String reviewId);

	@Transactional
	@Modifying
	@Query("update FcrResponseRemedations f set f.reviewStatus=:reviewStatus where f.reviewId=:reviewId and f.childReviewId=:childReview")
	public String updateResponseRemedation(String reviewStatus, String reviewId, String childReview);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM FcrResponseRemedations t WHERE t.reviewId = :reviewId AND t.childReviewId = :childReviewId")
	public void deleteByReviewIdAndChildReviewId(String reviewId, String childReviewId);
	
	@Transactional
	@Modifying
	@Query("update FcrResponseRemedations f set f.query=:query where f.reviewId=:reviewId and f.childReviewId=:childReviewId")
	public void updateFcrResponseRemedations(String query,String reviewId,String childReviewId);
}
