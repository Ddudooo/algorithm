package study.problem.kt

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val mergeAry = nums1 + nums2
        mergeAry.sort()

        val size = mergeAry.size
        if (size % 2 != 0) {
            return mergeAry[size / 2].toDouble()
        }
        return ((mergeAry[size / 2].toDouble() + mergeAry[size / 2 - 1].toDouble()) / 2)
    }
}