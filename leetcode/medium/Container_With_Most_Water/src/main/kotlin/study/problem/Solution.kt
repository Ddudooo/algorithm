package study.problem

class Solution {
    fun maxArea(heights: IntArray): Int {
        val size = heights.size
        var lo = 0
        var hi = size - 1
        var maxArea = 0

        while (lo < hi) {
            val area = minOf(heights[lo], heights[hi]) * (hi - lo)
            maxArea = maxOf(maxArea, area)

            if (heights[lo] < heights[hi])
                ++lo
            else --hi
        }

        return maxArea
    }
}