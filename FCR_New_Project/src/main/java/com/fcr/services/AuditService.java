package com.fcr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcr.entity.AuditTrail;
import com.fcr.repository.AuditRepo;

@Service
public class AuditService {
	
	@Autowired
	public AuditRepo auditRepo;
	
	public String insertAudit(AuditTrail trail) {
		auditRepo.save(trail);
		return "Audit Inserted";
	}
	
	public List<AuditTrail> fetchAudit(String reviewId){
		
		return auditRepo.getAudit(reviewId);
	}

}
