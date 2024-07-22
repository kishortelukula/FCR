package com.fcr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fcr.entity.TaskDetails;

@Repository
public interface FcrRepository extends JpaRepository<TaskDetails, Long>{

}
