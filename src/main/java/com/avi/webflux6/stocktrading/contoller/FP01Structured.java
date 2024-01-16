package com.avi.webflux6.stocktrading.contoller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funprogramstruct")
public class FP01Structured {

	List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9);
	
	@GetMapping("printlistnumber")
	public void printListNumbers() {		
		for(int num:nums) {
			System.out.println(num);
		}
	}
}
