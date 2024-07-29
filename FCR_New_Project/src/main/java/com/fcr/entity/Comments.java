package com.fcr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long slNo;
	private String reviewId;
	private String comment;
	private String activityLevel;
	private String commentedBy;
	private String time;

}
