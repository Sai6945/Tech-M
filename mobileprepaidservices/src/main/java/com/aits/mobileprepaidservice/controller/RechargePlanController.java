package com.aits.mobileprepaidservice.controller;

import org.springframework.web.bind.annotation.*;

import com.aits.mobileprepaidservice.entity.RechargePlan;
import com.aits.mobileprepaidservice.service.RechargePlanService;
 
import java.util.List;
 
@RestController
@RequestMapping("/plans")
public class RechargePlanController {
 
    private final RechargePlanService service;
 
    public RechargePlanController(RechargePlanService service) {
        this.service = service;
    }
 
    @GetMapping
    public List<RechargePlan> getAllPlans() {
        return service.getAllPlans();
    }
 
    @GetMapping("/{category}")
    public List<RechargePlan> getByCategory(@PathVariable String category) {
        return service.getPlanByCategory(category);
    }
    
    @PostMapping
    public RechargePlan insert(@RequestBody RechargePlan rechargeplan) {
    	
    	
    	return service.insert(rechargeplan);
    	
    	
    }
}
 
 
