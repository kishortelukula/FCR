package com.fcr.dto;

import com.fcr.entity.TaskDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CaseCreation {
	private String reviewId;
	private String division;
	private String portfolio;

}
