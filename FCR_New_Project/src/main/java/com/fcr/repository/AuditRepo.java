package com.fcr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fcr.entity.AuditTrail;
@Repository
public interface AuditRepo extends JpaRepository<AuditTrail, Long>{

}
