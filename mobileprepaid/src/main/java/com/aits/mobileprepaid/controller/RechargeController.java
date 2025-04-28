package com.aits.mobileprepaid.controller;

import org.springframework.web.bind.annotation.*;

import com.aits.mobileprepaid.entity.RechargeHistory;
import com.aits.mobileprepaid.service.RechargeService;

import java.util.List;

@RestController

public class RechargeController {

	
    private final  RechargeService service;

    public RechargeController(RechargeService service) {
        this.service = service;
    }

    @PostMapping("/recharge")
    public String recharge(
            @RequestParam Long userId,
            @RequestParam Integer planId,
            @RequestParam String paymentMethod) {
        return service.recharge(userId, planId, paymentMethod);
    }

    @GetMapping("recharge/history/{userId}")
    public List<RechargeHistory> getHistory(@PathVariable Long userId) {
        return service.getUserHistory(userId);
    }
}

