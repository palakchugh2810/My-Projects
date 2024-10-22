package Strings;

import java.util.ArrayList;

public class Rev {
	public static void main(String[] args) {
		
		reverseWords("sky is blue");
		
	}
	
	 public static void reverseWords(String s) {
	        char r;
	        ArrayList<String> arr= new ArrayList<String>();
	        String sb ="";
	        int i=s.length()-1, j=0;
	       while(i>0 && j<s.length()){
	    	   if(s.charAt(i)==' ' && j!=0)
	    	   {
	    		   sb=s.substring(i,j);
	    		   arr.add(sb);
	    		 //  System.out.print(sb);
	    		   j=i;
	    	   }
	    	   else if(s.charAt(i)==' '){
	        		j=i;
	        		sb=s.substring(i);
		    		  // System.out.print(sb);
		    		   arr.add(sb);

	        		
	        	}
	        	i--;
	        	

	        }
	       int l=0;
	       for(int k=0; k<s.length(); k++)
	       {
	    	   if(s.charAt(k)==' ' && l==0)
	    	   {
	    		  sb= s.substring(0,k);
	    		  l++;
	    		 // System.out.print(sb);
	    		  arr.add(" ");
	    		  arr.add(sb);
	    	   }
	    	  
	       }
	       System.out.println("rev string is " +arr.toString());
	       // return sb.toString();
	        
	    }

}
