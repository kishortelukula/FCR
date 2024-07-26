package com.fcr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcr.entity.TaskDetails;
import com.fcr.repository.FcrRepository;

@Service
public class TaskService {
	
	@Autowired
	FcrRepository repository;
	
	public List<TaskDetails> getGroupTasks(String groupName, String userName){
		return repository.groupTask(groupName, userName);
	}
	
	public List<TaskDetails> getMyTasks(String userName){
		return repository.myTask(userName);
	}

	public List<TaskDetails> fetchReviewId(String reviewId) {
		// TODO Auto-generated method stub
		return repository.fetchByReviewId(reviewId);
	}
	

}
