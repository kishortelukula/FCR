package com.fcr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fcr.entity.TaskDetails;

import jakarta.transaction.Transactional;

@Repository
public interface FcrRepository extends JpaRepository<TaskDetails, Long>{
	
	@Query("select a from TaskDetails as a  where a.assignTo=?1 and a.assignTo !=?2 and a.taskStatus!='Completed'")
	public List<TaskDetails> groupTask(String groupName, String userName);
	
	@Query("select a from TaskDetails as a  where a.assignTo=?1 and a.taskStatus!='Completed'")
	public List<TaskDetails> myTask(String userName);
	
	@Query("select a from TaskDetails as a  where a.reviewId=?1")
	public List<TaskDetails> fetchByReviewId(String reviewId);
	
	@Modifying
	@Transactional
	@Query("UPDATE TaskDetails t SET t.role = :role ,t.assignTo =:assignTo,t.taskStatus=:taskStatus WHERE t.reviewId = :reviewId and t.childReviedId is null and t.issueId is null")
	public void updateCase(String role,String assignTo,String taskStatus,String reviewId);
	
	@Modifying
	@Transactional
	@Query("UPDATE TaskDetails t SET t.role = :role ,t.assignTo =:assignTo,t.taskStatus=:taskStatus WHERE t.childReviedId = :childReviedId")
	public void updateCaseByChildReviewId(String role,String assignTo,String taskStatus,String childReviedId);


}
