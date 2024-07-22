package com.fcrAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.fcrAccess.entity.Users;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	
	
	@Query("select a.users from Users as a where a.groupName=?1")
	public String getUserFromGroup(String group);
	
	@Modifying
	@Transactional
	@Query("update Users as a set a.users=?1 where a.groupName=?2")
	public void updateUsers(String users,String group);


}
