package com.avi.webflux6.stocktrading.contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/streamapi")
public class StreamApiController {
	List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9);
	List<String> cources = List.of("Java","Cloud","PHP","Spring"
				,"Spring Boot","API","Microservices","Kubernatives"
			);
	
	/*
	 * print the list using stream
	 */
	@GetMapping("getlistnumber")
	public List<Integer> getListNumbers() {		
		nums.stream().forEach(System.out::println);
		return nums;
	}
	
	/*
	 * check even number using stream
	 */
	@GetMapping("getevennumber")
	public List<Integer> getEvenNumbers() {
		
		List<Integer> evenNum = nums.stream()
		.filter(nums->nums%2 == 0)
		.collect(Collectors.toList());
		evenNum.stream().forEach(System.out::println);
		return evenNum;
	}
	
	/*
	 * find specific word exits and return o/p using stream
	 */
	@GetMapping("getcourcewithword/{word}")
	public List<String> getCourceWithWord(@PathVariable String word){
		return cources
				.stream()
				.filter(cource->cource.contains(word))
				.collect(Collectors.toList());
	}
	
	/*
	 * find specific length string return all using stream
	 */
	@GetMapping("getcourseusinglen/{len}")
	public List<String> getCourceUsingLen(@PathVariable Integer len){
		return cources
				.stream()
				.filter(cource->cource.length() > len)
				.collect(Collectors.toList());
	}
	
	/*
	 * find power of number from list
	 */
	@GetMapping("getpowerofnumber/{n}")
	public List<Double> getPowerOfNumber(@PathVariable Integer n){
		return nums.stream()
//				.filter(num->num%2 == 0)
				.map(nums->Math.pow(nums, n))
				.collect(Collectors.toList());
	}
	
	/*
	 * get length of each element from list
	 */
	@GetMapping("getlenofelement")
	public Map<Object, Object> getLenOfElement(){
		Map<Object, Object> courceLen = cources.stream()
//				.filter(cource->cource.contains("Spring"))
				.collect(Collectors.toMap(
						cource->cource.toString(), cource->cource.toString().length())
						);
		return courceLen;
	}
}
