package com.fcr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.fcr.entity.CaseDetails;
import com.fcr.repository.CaseDetailsRepo;

@Service
public class CaseDetailsService {
	
	@Autowired
	CaseDetailsRepo caseDetailsRepo;
	
	public String insertcasedetails(@RequestBody CaseDetails caseDetails) {
		caseDetailsRepo.save(caseDetails);
		return "inserted";
	}

}
