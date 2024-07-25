package com.fcr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fcr.entity.FCRAdmin;

@Repository
public interface FCRAdminCofigRepo extends JpaRepository<FCRAdmin, Long> {
	
	@Query("select distinct(a.groupname) from FCRAdmin as a")
	public List<String> findGroup();
	
	@Query("select a.division from FCRAdmin as a where a.groupname=?1")
	public List<String> findDivisionByGroup(String groupName);

}
