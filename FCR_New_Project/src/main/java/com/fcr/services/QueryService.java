package com.fcr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcr.entity.FcrQuery;
import com.fcr.repository.QueryRepo;

@Service
public class QueryService {

	@Autowired
	QueryRepo queryRepo;
	
	public String insertQuery(FcrQuery fcrQuery) {
		queryRepo.save(fcrQuery);
		return "Query Inserted";
	}
	
	public List<FcrQuery> getQuery(String querySeq,String childReviewId){
		return queryRepo.getQuery(querySeq,childReviewId);
	}
	
	public String deleteQuery(String querySeq,String childReviewId) {
		queryRepo.deleteQuery(querySeq,childReviewId);
		return "Query Deleted Successfully";
	}
	
	public String updateQueryResponse(String response,String responseBy,String responseOn,String querySeq,String childReviewId) {
		queryRepo.updateQueryResponse(response, responseBy, responseOn, querySeq, childReviewId);
		return "Updated Query Response Successfully";
	}
}
