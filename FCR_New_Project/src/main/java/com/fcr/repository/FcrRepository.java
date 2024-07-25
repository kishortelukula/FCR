package com.fcr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fcr.entity.TaskDetails;

@Repository
public interface FcrRepository extends JpaRepository<TaskDetails, Long>{
	
	@Query("select a from TaskDetails as a  where a.assignTo=?1 and a.assignTo !=?2")
	public List<TaskDetails> groupTask(String groupName, String userName);
	
	@Query("select a from TaskDetails as a  where a.assignTo=?1")
	public List<TaskDetails> myTask(String userName);

}
