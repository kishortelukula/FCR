package com.fcr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fcr.entity.Comments;

public interface commentRepo extends JpaRepository<Comments, Long>{
	
	@Query("select a from Comments as a  where a.reviewId=?1")
	public List<Comments> getComments(String reviewId);

}
