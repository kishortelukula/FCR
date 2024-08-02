package com.fcr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fcr.entity.FcrDocTag;

@Repository
public interface FcrDocTagRepo extends JpaRepository<FcrDocTag, Long>{

}
