package study.problem.kt

class Solution {
    fun abs(a: Int, b: Int): Int {
        if (a > b) return a - b
        return b - a
    }

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var min = Int.MAX_VALUE
        var ans = 0
        nums.sort()
        for (i in 0 until nums.size - 2) {
            var start = i + 1
            var end = nums.size - 1
            while (start < end) {
                var sum = nums[i] + nums[start] + nums[end]
                var dist = abs(
                    target,
                    sum
                )
                if (dist < min) {
                    min = dist
                    ans = sum
                }
                if (sum == target) break
                else if (sum < target) start++
                else end--
            }
        }
        return ans
    }
}