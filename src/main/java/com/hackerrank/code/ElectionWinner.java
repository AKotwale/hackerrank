package com.hackerrank.code;

import java.util.Arrays;

public class ElectionWinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String[] votes = {"Alex", "Bob", "Zen"};
      System.out.println(electionWinner(votes));
	}
	
	
	private static String electionWinner(String[] votes) {
		
		     if(votes.length == 1) {
		    	    return votes[0];
		     }
		     
		     Arrays.sort(votes);
		     int counter =0;
		     int numberOfVotes = 0;
		     int index = 0; 
		     String winner = "";
		     while(index < votes.length -1) {
		    	  
		    	    if(votes[index] == votes[index +1]) {
		    	    	      counter ++;
		    	    	      index = index +1;
		    	    }
		    	    
		    	    if(numberOfVotes <= counter) {
		    	    	     numberOfVotes = counter;
		    	    	     winner =votes[index];
		    	    }
		    	    
		    	    index = index +1;
		    	 
		     }
		     
		     if(index == votes.length -1) {
		    	     if(votes[index] != votes[index -1]) {
		    	    	     if(numberOfVotes <= counter) {
		    	    	    	     winner = votes[index];
		    	    	     }
		    	     }
		     }
		     
		     return winner; 
		
	}

}
