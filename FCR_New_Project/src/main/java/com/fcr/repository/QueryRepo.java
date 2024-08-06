package com.fcr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fcr.entity.FcrQuery;

import jakarta.transaction.Transactional;
@Repository
public interface QueryRepo extends JpaRepository<FcrQuery, Long>{
	
	@Query("select a from FcrQuery as a  where  a.childReviewId=:childReviewId")
	public List<FcrQuery> getQuery(String childReviewId);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM FcrQuery t WHERE t.querySeq = :querySeq and t.childReviewId=:childReviewId")
	public void deleteQuery(String querySeq,String childReviewId);

	@Transactional
	@Modifying
	@Query("update FcrQuery f set f.response=:response,f.responseBy=:responseBy,f.responseOn=:responseOn where f.querySeq=:querySeq and f.childReviewId=:childReviewId")
	public void updateQueryResponse(String response,String responseBy,String responseOn,String querySeq,String childReviewId);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM FcrQuery t WHERE t.childReviewId=:childReviewId")
	public void deleteQueryByChildReview(String childReviewId);
}
