package com.fcr.entity;

import java.security.Timestamp;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuditTrail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long slNo;
	private String reviewId;
	private String taskId;
	private String currentAction;
//	@Temporal(TemporalType.TIMESTAMP)
	private String inTime;
//	@Temporal(TemporalType.TIMESTAMP)
	private String outTime;
	private String activityLevel;
	private String actionedBy;
	
	
}
