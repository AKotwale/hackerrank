package com.hackerrank.code;


	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;
	
	public class Anagrams {
	    public static int numberNeeded(String first, String second) {
	        char[] firstString = null;
	        char[] secondString = null;
	        int numberOfCount = 0;
	         if(first != null) {
	             firstString = first.toCharArray();
	         }
	         if(second != null) {
	             secondString = second.toCharArray();
	         }
	        
	        if(firstString.length == 1 && secondString.length == 1) {
	              return 0;
	        }
	        
	        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
	        
	        for(int i = 0; i < firstString.length ; i ++) {
	            
	            if(charMap.containsKey(firstString[i])) {
	                charMap.put(firstString[i], charMap.get(firstString[i])+1);
	            } else {
	                charMap.put(firstString[i], 1);
	            }
	                
	        }
	        
	        for(int i = 0; i < secondString.length ; i ++) {
	              if( charMap.containsKey(secondString[i])) {
	                  charMap.put(secondString[i],0);
	              } else {
	                  charMap.put(secondString[i],1);
	              }
	        }
	        
	         for(Character key : charMap.keySet()) {
	             numberOfCount = numberOfCount + charMap.get(key);
	         }
	        
	      
	        
	        return numberOfCount;
	    }
	  
	public static void main(String argc[]) {
		System.out.println(numberNeeded("eeeeee", "cde"));
	}
	
}
