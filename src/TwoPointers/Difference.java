package TwoPointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Difference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = Arrays.asList(1,1,3,3,5,5,6,6,6,9,10);
		int count = solve(A, 9);
		System.out.println("total pairs with difference equal to k are " + count);

	}
	public static int solve(List<Integer> A, int B) {
		Collections.sort(A);
		int low=0;
		int high=A.size()-1;
		int count=0;
		int difference=0;
		while(low<A.size())
		{			
			if()
		}
		return count;
	
	}
	
	/*
	 * int count=0, i=0,j=1; Collections.sort(A); while(j<A.size() && i<A.size()) {
	 * if(i==j){j++;continue;} if(i>0&&j>0 && A.get(j)==A.get(j-1)
	 * &&A.get(i)==A.get(i-1)){i++;j++;continue;} int diff = A.get(j)-A.get(i);
	 * if(diff==B ){count++;i++;j++;} if(diff<B){j++;} if(diff>B){i++;}
	 * 
	 * 
	 * 
	 * } return count;
	 */

}
