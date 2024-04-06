package com.avi.webflux6.stocktrading.contoller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
	@GetMapping("/get_duplicate")
	public void getDuplicate() {
		List<Integer> num = Arrays.asList(1,2,4,5,4,3,2);
	    Map<Integer, Long> numCount = num.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()));
	    
	    List<Integer> result = numCount.entrySet().stream().filter(n->n.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
	    System.out.println("Duplicate numbers: " + result);
	}
}
