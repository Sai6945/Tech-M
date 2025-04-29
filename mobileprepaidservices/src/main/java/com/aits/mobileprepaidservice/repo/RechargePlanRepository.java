package com.aits.mobileprepaidservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aits.mobileprepaidservice.entity.RechargePlan;

public interface RechargePlanRepository extends JpaRepository<RechargePlan,Integer> {
	List<RechargePlan>findByCategory(String category);

}
