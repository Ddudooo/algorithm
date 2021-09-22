package study.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		List<Integer> merge = merge(nums1, nums2);
		return median(merge);
	}

	private double median(List<Integer> merge) {
		if (merge.size() % 2 != 0) {
			return merge.get(merge.size() / 2);
		}
		return (double) (merge.get(merge.size() / 2) + merge.get(merge.size() / 2 - 1)) / 2;
	}

	private List<Integer> merge(int[] nums1, int[] nums2) {
		List<Integer> merge = new ArrayList<>();
		Arrays.stream(nums1)
			.boxed()
			.forEach(merge::add);
		Arrays.stream(nums2)
			.boxed()
			.forEach(merge::add);

		Collections.sort(merge);
		return merge;
	}
}