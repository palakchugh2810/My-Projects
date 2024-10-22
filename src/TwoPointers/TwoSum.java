package TwoPointers;

import java.util.Arrays;
import java.util.List;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = Arrays.asList(1,1,3,3,5,5,6,6,6,9,10);
		int count = solve(A, 9);
		System.out.println("total pairs with sum equal to k are " + count);

	}

	public static int solve(List<Integer> A, int B) {
		int i = 0, j = A.size() - 1,count = 0;
		int sum = 0;
		 
		if (A.size() == 1)
			return 0;

		if (A.get(i) == A.get(j) && sum != B) 
			return 0;

		while (i < j && i < A.size() && i!=j) {
			sum = A.get(i) + A.get(j);

			
			if (sum > B)
				j--;
			if (sum < B)
				i++;

			if (sum == B && A.get(i) == A.get(j)) {
				int temp = j - i + 1;// count of elements
				count += (temp * (temp - 1)) / 2;return count;
				
			}

			if (sum == B)

			{
				int counti = 1, countj = 1;
				

				while (i < j && A.get(i + 1) == A.get(i)) {
					i++;
					counti++;
				}

				 while (i < j && A.get(j - 1) == A.get(j)) {
					j--;
					countj++;
				}

				
                
				i++;
				j--;
                
				count += counti * countj;
			}
		}

		return count;
	}

}
