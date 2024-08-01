package com.fcr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fcr.entity.FcrResponseRemedation;

import jakarta.transaction.Transactional;

@Repository
public interface ResponseRemedationRepo extends JpaRepository<FcrResponseRemedation, Long> {

	@Query("select a from FcrResponseRemedation as a where a.reviewId=:reviewId")
	public List<FcrResponseRemedation> fetchResponseRemedation(String reviewId);

	@Transactional
	@Modifying
	@Query("update FcrResponseRemedation f set f.reviewStatus=:reviewStatus where f.reviewId=:reviewId and f.childReviewId=:childReview")
	public String updateResponseRemedation(String reviewStatus, String reviewId, String childReview);
}
