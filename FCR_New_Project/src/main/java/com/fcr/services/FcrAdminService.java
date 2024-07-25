package com.fcr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcr.repository.FCRAdminCofigRepo;

@Service
public class FcrAdminService {
	
	@Autowired
	FCRAdminCofigRepo repo;
	
	public List<String> allGroups(){
		return repo.findGroup();
	}
	
	public List<String> divisionByGroup(String group){
		return repo.findDivisionByGroup(group);
	}

}
