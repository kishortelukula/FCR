package com.fcr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.fcr.entity.Comments;

import jakarta.transaction.Transactional;

public interface CommentRepo extends JpaRepository<Comments, Long>{
	
	@Query("select a from Comments as a  where a.reviewId=?1")
	public List<Comments> getComments(String reviewId);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Comments t WHERE t.reviewId = :reviewId AND t.slNo = :slNo")
	public void deleteByReviewIdAndSlNo(String reviewId, Long slNo);


}
