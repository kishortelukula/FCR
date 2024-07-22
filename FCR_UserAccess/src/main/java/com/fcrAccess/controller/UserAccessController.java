package com.fcrAccess.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fcrAccess.entity.Users;
import com.fcrAccess.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/Users")
public class UserAccessController {

	@Autowired
	UserService service;

	@PostMapping("/AddUsers")
	public ResponseEntity<String> postMethodName(@RequestBody Users users) {
		String response = service.addUsers(users);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/FindGroupByUsers")
	public ResponseEntity<String> getMethodName(@RequestParam("GroupName") String GroupName) {
		String response = service.getUsers(GroupName);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/FindAll")
	public ResponseEntity<List<Users>> getMethodName() {
		List<Users> userLists = service.getAllUsers();
		return new ResponseEntity<>(userLists, HttpStatus.OK);
	}

}
