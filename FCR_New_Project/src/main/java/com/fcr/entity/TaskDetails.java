package com.fcr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TaskDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long taskId;
	private String taskStatus;
	private String processName;
	private String assignTo;
	private String taskSubject;
	private String reviewId;
	private String division;
	private String portfolio;
	private String childReviedId;
	private String issueId;
	private String trackIssueId;
	

}
