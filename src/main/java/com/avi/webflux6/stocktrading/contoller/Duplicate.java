package com.avi.webflux6.stocktrading.contoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/duplicate")
public class Duplicate {

	@GetMapping("/remove_dup")
	public void removeDuplicate() {
		List<Integer> num = new ArrayList<>();
		num.add(2);
		num.add(5);
		num.add(5);
		num.add(6);
		List<Integer> numFil = num.stream().distinct().toList();
		System.out.println(numFil);
	}
	
	@GetMapping("/remove_dup_core")
	public void removeDuplicateCore() {
		int[] arr = {2,5,5,6};
	    int j = 0;
	    for (int i = 0; i < arr.length - 1; i++) {
	        if (arr[i] != arr[i + 1]) {
	            arr[j++] = arr[i];
	        }
	    }
	    arr[j++] = arr[arr.length - 1];
	    for (int i = 0; i < j; i++) {
	        System.out.println(arr[i]);
	    }
	}
}
