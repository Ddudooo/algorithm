package study.problem.kt

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val sumMap = mutableMapOf<Int, Int>()
        lateinit var result: IntArray
        for (i in 0 until nums.size) {
            val num = nums[i]
            if (sumMap.containsKey(num)) {
                result = intArrayOf(sumMap[num]!!, i)
                break
            }
            sumMap[target - num] = i
        }
        return result
    }
}