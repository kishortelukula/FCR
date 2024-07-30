package com.fcr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fcr.entity.CaseDetails;
@Repository
public interface CaseDetailsRepo extends JpaRepository<CaseDetails, Long>{

}
