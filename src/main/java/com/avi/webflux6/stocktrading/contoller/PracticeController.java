package com.avi.webflux6.stocktrading.contoller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/practice")
public class PracticeController {
	
	private static final int ALPHABET_COUNT = 26;
	
	@GetMapping("/anargam/{val1}/{val2}")
	public String checkAnargam(@PathVariable String val1, @PathVariable String val2) {		
		if(val1.length() != val2.length()) {
			//System.out.println(val1+" and "+val2+" are not anagram.");
			//System.exit(0);
			return val1+" and "+val2+" are not anagram.";
		}
		char[] charList1 = val1.toLowerCase().toCharArray();
		char[] charList2 = val2.toLowerCase().toCharArray();
		Arrays.sort(charList1);
		Arrays.sort(charList2);
		if(Arrays.equals(charList1, charList2)) {
			return val1+" and "+val2+" are anagram.";
			//System.out.println(val1+" and "+val2+" are anagram.");
		}else {
			return val1+" and "+val2+" are not anagram.";
			//System.out.println(val1+" and "+val2+" are not anagram.");
		}
		
	}
	
	@GetMapping("pangram/{str}")
	public Boolean checkPangram(@PathVariable String str) {
		if(str == null) {
			return false;
		}
		Boolean[] alphabetMarker  = new Boolean[ALPHABET_COUNT];
		Arrays.fill(alphabetMarker, false);
		str = str.toUpperCase();
		int alphabetIndex = 0;
		for(int i =0;i<str.length();i++) {
			if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				//System.out.println("str - "+str.charAt(i));
				alphabetIndex = str.charAt(i)-'A';
				alphabetMarker[alphabetIndex] = true;
				//System.out.println(alphabetIndex+" == "+alphabetMarker[alphabetIndex]);
			}
		}
		
		for (boolean index : alphabetMarker) {
	        if (!index) {
	            return false;
	        }
	    }	    
		return true;
	}
	
	
	@GetMapping("weightstring/{str}")
	public int weightString(@PathVariable String str) {
		int wgt = 0;
		char[] aplphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for(int i=0;i<str.length();i++) {
			wgt += new String(aplphabet).indexOf(str.charAt(i))+1;
			System.out.println(wgt+" - char at - "+str.charAt(i));
		}
		return wgt;
	}
	
	@GetMapping("startofstring/{ch}")
	public String startOfString(@PathVariable char ch) {
		String[] arrayOfString = {"apple","sample", "search","cat"};
		ArrayList<String> outString = new ArrayList<String>();
		for(int i=0;i<arrayOfString.length;i++) {			
			if(arrayOfString[i].charAt(0) == ch) {
				outString.add(arrayOfString[i]);
			}
		}
		return outString.toString();
	}
	@GetMapping("reversestring/{str}")
	public String reverseString(@PathVariable String str) {
		//String strRev = new StringBuilder(str).reverse().toString();
		String strRev = new String();
		for(int i=str.length()-1;i>=0;i--) {
			strRev +=str.charAt(i);
			//System.out.println(str.charAt(i));
		}
		return strRev;
	}
	
	static int n1=0,n2=1,n3=0;
	@GetMapping("fibonacci/{count}")	
	public void printFibonacci(@PathVariable int count) {
		if(count>0) {
			n3 = n1+n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" "+n3);
			printFibonacci(count-1);
		}
	}
	
	@GetMapping("get2smallno")
	public int get2SmallNo() {
		int num[] = {1,3,6,1,3,2,7};
		int temp;
		int size = num.length;
		for(int i=0;i<size;i++) {
			for(int j=i+1;j<i;j++) {
				if(num[i] < num[j]) {
					temp   = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		//Arrays.sort(num);
		System.out.println("---"+size+" <-size->"+num.toString());
		return num[size-2];
	}
	
	@GetMapping("powerofnum/{num}/{power}")
	public boolean powerOfNum(@PathVariable int num, @PathVariable int power) {
		while(num>1) {
			if(num % power !=0) {
				return false;
			}
			num/=power;
		}
		return num == 1;
	}
	
	@GetMapping("calculateage/{birthdate}")//yyyy-mm-dd
	public String calculateAge(@PathVariable String birthdate) {
		LocalDate dob = LocalDate.parse(birthdate);
		LocalDate today = LocalDate.now();
		int age = today.getYear() - dob.getYear();
		int month = today.getMonthValue() - dob.getMonthValue();
		int day = today.getDayOfMonth() - dob.getDayOfMonth();
		if(month < 0) {
			age--;
			month +=12;
		}
		if(day < 0) {
			month --;
			day +=30;
		}
		
		System.out.println("You are "+ age + " years, " + month +" months, and " + day + " days old");
		return "You are "+ age + " years, " + month +" months, and " + day + " days old";
	}
	
	@GetMapping("myfunction")
	public void myFunction() {
		/*Stream.of("a","b","c","d","e")
	    .parallel()
	    .forEach(System.out::println);
		return val1+" is not panagram.";*/
		String sent = "Good Bye Bye";
		List<String> list = new ArrayList<String>(Arrays.asList(sent.split(" ")));
		//List<String> list = Arrays.asList("a","a","b","c","b");
		List<String> dList = list.stream().distinct().collect(Collectors.toList());
		System.out.println(dList);
		
		int[] records = new int[] { 1, 2, 0, 5, 0, 2, 4, 3, 3, 3 };
        System.out.println(Arrays.toString(records));
	}
	
	@GetMapping("reversearray")
	public void reverseArray() {
		String[] strArray = {"h", "e", "l", "l", "o"};
		int siz = strArray.length;
		String temp;
		for(int i = 0, j = siz-1; i < j; i++, j--) {
			temp = strArray[i];
			strArray[i] = strArray[j];
			strArray[j] = temp;
		}
		System.out.println(Arrays.toString(strArray));
		
//		Java 8 
//		Collections.reverse(Arrays.asList(strArray));
//		System.out.println(Arrays.toString(strArray));
	}
	
	@GetMapping("pattern")
	public void patternPrint() {
		char[] str = "VenkataSiva".toCharArray();
		int len = str.length;

		for(int i=len;i>=1;i--){
			for(int j=1;j<i;j++){
				System.out.print(str[j-1]);
			}
			System.out.println();
		}
	}
}
