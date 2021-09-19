package study.problem;

class Solution {

	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		int idx = 0;
		total:
		for (int i = 0; i < nums.length - 1; i++) {
			int num1 = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				int num2 = nums[j];
				if (num1 + num2 == target) {
					result[0] = i;
					result[1] = j;
					break total;
				}
			}
		}
		return result;
	}
}