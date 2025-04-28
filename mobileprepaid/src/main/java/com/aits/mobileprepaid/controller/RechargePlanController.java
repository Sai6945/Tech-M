package com.aits.mobileprepaid.controller;




import org.springframework.web.bind.annotation.*;

import com.aits.mobileprepaid.entity.RechargePlan;
import com.aits.mobileprepaid.service.RechargePlanService;

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
        return service.getPlansByCategory(category);
    }
    
    @PostMapping
    public RechargePlan insert(@RequestBody RechargePlan rechargeplan) {
    	
    	
    	return service.insert(rechargeplan);
    	
    	
    }
}
