package leetcode;

public class RemoveDuplicatesInplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = { 1, 5, 3, 5, 2, 8, 3, 9, 5 };

		int len = removeDuplicates(numbers);
		System.out.println(len);

	}

	public static int removeDuplicates(int[] nums) {
		int index = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[index] = nums[i];
				index++;
			}
		}
		return nums.length;

	}

}
