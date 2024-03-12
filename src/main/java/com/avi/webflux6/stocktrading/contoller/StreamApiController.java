package com.avi.webflux6.stocktrading.contoller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/streamapi")
public class StreamApiController {
	List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9);
	List<String> cources = List.of("Java","Cloud","PHP","Spring","Spring"
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
	
	/*
	 * get total of all element from list using reduce function
	 * 
	 * (a, b)-> a + b => fun(a,b){ a+b }  which return total of number
	 */
	
	@GetMapping("gettotaloflist")
	public int getTotalOfList() {
		//return nums.stream().reduce(0, (a, b)-> a + b);
		return nums.stream().reduce(0, Integer::sum);//sum is in build function
	}
	
	/*
	 * return the longer string from list 
	 */
	@GetMapping("getlongstring")
	public Optional<String> getLongStringFromList() {
		return cources.stream().reduce((w1,w2)-> w1.length()>w2.length() ? w1:w2);
		
	}
	
	/*
	 * concanate list using reduce
	 */
	@GetMapping("getlistinstring")
	public Optional<String> getListInString() {
		return cources.stream().sorted().distinct().reduce((str1,str2)->str1+'-'+str2);
	}
	
	/*
	 * sorting of length wise of string list
	 * 
	 */
	
	@GetMapping("getlistsorted")
	public List<String> getListSorted() {
		return cources.stream().sorted(Comparator.comparing(cource->cource.length())).toList();
	}
	
	/*
	 * functional interface
	 * Predicate - accept one agr and return boolean
	 * Function  - accept one agr and return result
	 * Consumer - accept one agr and return nothing 
	 * Collector - function which return new mutable result
	 */
	@GetMapping("functionalinterfaceoddnum")
	public void functionalInterfaceOddNum(){
		
		Predicate<Integer> predicateOldNum = num->num%2 == 0;
		/*
		 * working of predicate
		 */
		
		Predicate<Integer> predicateOldNum1 = new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer num) {
				// TODO Auto-generated method stub
				return num%2 == 0;
			}
		};
		Function<Integer, Integer> squareOfNum = x->x*x;
		
		/*
		 * working of function 
		 */
		Function<Integer,Integer> squareOfNum1 = new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer x) {
				// TODO Auto-generated method stub
				return x*x;
			}
		};
		
		
		
		Collector<Integer, ?, List<Integer>> convertToList = Collectors.toList();
		
		Consumer<Integer> printNum = System.out::println;
		/*
		 * working of consumer 
		 */
		printNum();
		
		nums.stream()
				.filter(predicateOldNum)
				.map(squareOfNum)
				.collect(convertToList)
				.forEach(printNum);
	}

	private void printNum() {
		Consumer<Integer> printNum1 = new Consumer<Integer>() {
			
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		};
	}
	
	
}
