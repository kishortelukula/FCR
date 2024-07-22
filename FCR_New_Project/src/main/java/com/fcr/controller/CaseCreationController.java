package com.fcr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fcr.dto.CaseCreation;
import com.fcr.services.CaseCreationService;

@RestController
@RequestMapping("/fcr")
public class CaseCreationController {
	
	@Autowired
	private CaseCreationService creationService;
	
	@PostMapping("/caseCreation")
	public ResponseEntity<String> caseCreation(@RequestBody CaseCreation caseCreation){
		String created = creationService.createCase(caseCreation);
		return new ResponseEntity<String>(created,HttpStatus.OK);
	}

}
