package com.fcr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fcr.dto.CaseCreation;
import com.fcr.entity.AuditTrail;
import com.fcr.entity.TaskDetails;
import com.fcr.services.AuditService;
import com.fcr.services.CaseCreationService;
import com.fcr.services.FcrAdminService;
import com.fcr.services.TaskService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/fcr")
@CrossOrigin("*")
public class CaseCreationController {
	
	@Autowired
	private CaseCreationService creationService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	FcrAdminService fcrAdminService;
	
	@Autowired
	AuditService auditService;
	
	@PostMapping("/caseCreation")
	public ResponseEntity<String> caseCreation(@RequestBody CaseCreation caseCreation){
		String created = creationService.createCase(caseCreation);
		return new ResponseEntity<String>(created,HttpStatus.OK);
	}
	
	@PutMapping("/updateCase")
	public ResponseEntity<String> updateCase(@RequestParam String role ,@RequestParam String assignTo , @RequestParam  String reviewId){
		creationService.updateCase(role,assignTo, reviewId);
		return null;
	}
	
	@GetMapping("/fetchByReviewId")
	public ResponseEntity<List<TaskDetails>> fetchReview(@RequestParam String reviewId) {
		return new ResponseEntity<List<TaskDetails>>(taskService.fetchReviewId(reviewId),HttpStatus.OK);
	
	}
	
	@GetMapping("/MyTask")
	public ResponseEntity<List<TaskDetails>> getMethodName(@RequestParam("userName") String userName) {
		return new ResponseEntity<List<TaskDetails>>(taskService.getMyTasks(userName),HttpStatus.OK);
	
	}
	@GetMapping("/GroupTask")
	public ResponseEntity<List<TaskDetails>> getGropu(@RequestParam("groupName") String groupName,@RequestParam("userName") String userName) {
		return new ResponseEntity<List<TaskDetails>>(taskService.getGroupTasks(groupName, userName),HttpStatus.OK);
	
	}
	
	@GetMapping("/Group")
	public ResponseEntity<List<String>> findDivision(@RequestParam("group") String group){
		return new ResponseEntity<List<String>>(fcrAdminService.divisionByGroup(group),HttpStatus.OK);
	}
	
	@GetMapping("/Division")
	public ResponseEntity<List<String>> allGroups(){
		return new ResponseEntity<List<String>>(fcrAdminService.allGroups(),HttpStatus.OK);
	}
	
	@PostMapping("/auditTrail")
	public ResponseEntity<String> insertAudit(@RequestBody AuditTrail auditTrail){
		String audit = auditService.insertAudit(auditTrail);
		return new ResponseEntity<String>(audit,HttpStatus.OK);
	}
	
	@GetMapping("/fetchAudit")
	public ResponseEntity<List<AuditTrail>> getAudit(@RequestParam String reviewId){
		return new ResponseEntity<List<AuditTrail>>(auditService.fetchAudit(reviewId),HttpStatus.OK);
		
	}}
