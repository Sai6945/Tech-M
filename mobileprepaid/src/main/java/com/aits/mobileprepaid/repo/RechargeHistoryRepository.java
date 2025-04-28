package com.aits.mobileprepaid.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aits.mobileprepaid.entity.RechargeHistory;


public interface RechargeHistoryRepository extends JpaRepository<RechargeHistory, Long>{

	
	List<RechargeHistory> findByUserId(Long userId);
	
}
