package com.aits.mobileprepaidservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aits.mobileprepaidservice.entity.RechargeHistory;

public interface RechargeHistoryRepository extends JpaRepository<RechargeHistory,Long> {
	List<RechargeHistory>findByUserId(Long userId);

}
