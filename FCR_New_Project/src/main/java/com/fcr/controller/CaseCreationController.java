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
import com.fcr.entity.CaseDetails;
import com.fcr.entity.Comments;
import com.fcr.entity.TaskDetails;
import com.fcr.services.AuditService;
import com.fcr.services.CaseCreationService;
import com.fcr.services.CaseDetailsService;
import com.fcr.services.CommentService;
import com.fcr.services.FcrAdminService;
import com.fcr.services.TaskService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	CaseDetailsService caseDetailsService;
	
	@PostMapping("/caseCreation")
	public ResponseEntity<String> caseCreation(@RequestBody CaseCreation caseCreation){
		String created = creationService.createCase(caseCreation);
		return new ResponseEntity<String>(created,HttpStatus.OK);
	}
	
	@PutMapping("/updateTask")
	public ResponseEntity<String> updateCase(@RequestParam String role ,@RequestParam String assignTo , @RequestParam  String reviewId){
		creationService.updateCase(role,assignTo, reviewId);
		return new ResponseEntity<String>("UpdatedTask",HttpStatus.OK);
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
	@GetMapping("/getSpocList")
	public ResponseEntity<List<String>> getSpoc(@RequestParam String groupname,@RequestParam String division){
		return new ResponseEntity<List<String>>(fcrAdminService.spocList(groupname, division),HttpStatus.OK);
	}
//Audit-------------	
	@PostMapping("/auditTrail")
	public ResponseEntity<String> insertAudit(@RequestBody AuditTrail auditTrail){
		String audit = auditService.insertAudit(auditTrail);
		return new ResponseEntity<String>(audit,HttpStatus.OK);
	}
	
	@GetMapping("/fetchAudit")
	public ResponseEntity<List<AuditTrail>> getAudit(@RequestParam String reviewId){
		return new ResponseEntity<List<AuditTrail>>(auditService.fetchAudit(reviewId),HttpStatus.OK);
		
	}
	
	@PostMapping("/insertAudit")
	public ResponseEntity<String> auditBefore(@RequestBody AuditTrail auditTrail){
		String res = auditService.auditBefore(auditTrail);
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	@PutMapping("/updateAuidt")
	public ResponseEntity<String> auditAfter(@RequestParam String currentAction,@RequestParam String outTime,@RequestParam String reviewId,@RequestParam String slNo){
		String result = auditService.auditAfter(currentAction, outTime, reviewId, slNo);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
//	------------------------- 
	
//	Comments-----------------
	@PostMapping("/comments")
	public ResponseEntity<String> insertComments(@RequestBody Comments comments){
		String res = commentService.insertcomment(comments);
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}

	@GetMapping("/getComments")
	public ResponseEntity<List<Comments>> getComments(@RequestParam String reviewId){
		return new ResponseEntity<List<Comments>>(commentService.fetchComments(reviewId),HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteComments")
	public ResponseEntity<String> deleteComments(@RequestParam String reviewId,@RequestParam Long slNo){
		String res = commentService.deleteComments(reviewId,slNo);
		return new ResponseEntity<String>(res,HttpStatus.OK); 
		
	}
	
//	---------------------------
//	caseDetails-------------------
	@PostMapping("/insertcaseDetails")
	public ResponseEntity<String> insertCaseDetails(@RequestBody CaseDetails caseDetails){
		String res = caseDetailsService.insertcasedetails(caseDetails);
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	@PutMapping("/updateCaseDetails")
	public ResponseEntity<String> updateCaseDetails(@RequestParam String childReviewId,@RequestParam String issueId,@RequestParam String trackIssueId,@RequestParam String headOfFcrAction,@RequestParam String caseStatus,@RequestParam String srCreditReview,@RequestParam String headOfFcr,@RequestParam String creditReview,@RequestParam String reviewId ) {
		String result	= caseDetailsService.updateCaseDetails(childReviewId, issueId, trackIssueId, headOfFcrAction, caseStatus, srCreditReview, headOfFcr, creditReview, reviewId);
		return new ResponseEntity<String>(result,HttpStatus.OK); 
	}
	
	@GetMapping("/fetchCaseDetails")
	public ResponseEntity<List<CaseDetails>> fetchCaseDetails(@RequestParam String reviewId){
		return new ResponseEntity<List<CaseDetails>>(caseDetailsService.fetchCaseDetails(reviewId),HttpStatus.OK);
	}
	 
//	-------------------------------
}
