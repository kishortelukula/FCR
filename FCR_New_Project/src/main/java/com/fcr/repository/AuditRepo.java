package com.fcr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fcr.entity.AuditTrail;
@Repository
public interface AuditRepo extends JpaRepository<AuditTrail, Long>{
	
	@Query("select a from AuditTrail as a  where a.reviewId=?1")
	public List<AuditTrail> getAudit(String reviewId);

}
