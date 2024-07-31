package com.fcr.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	public List<String> spocList(String groupname,String division){
		String res = repo.spocList(groupname, division);
		List<String> l1 = Arrays.stream(res.split(","))
                .collect(Collectors.toList());
		System.out.println(l1);
		return l1;
	}

}
