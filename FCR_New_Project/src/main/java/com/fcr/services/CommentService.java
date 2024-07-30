package com.fcr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcr.entity.Comments;
import com.fcr.repository.CommentRepo;

@Service
public class CommentService {

	@Autowired
	public CommentRepo commentRepo;

	public String insertcomment(Comments comments) {
		commentRepo.save(comments);
		return "Comments Inserted";
	}

	public List<Comments> fetchComments(String reviewId) {

		return commentRepo.getComments(reviewId);
	}

	public String deleteComments(String reviewId, Long slNo) {
		commentRepo.deleteByReviewIdAndSlNo(reviewId, slNo);
		return "Delete Succesfully";
	}

}
