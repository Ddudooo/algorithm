package study.problem.kt

class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val set = HashSet<List<Int>>()
        nums.sort()
        for (i in 0 until nums.size - 3) {
            for (j in i + 1 until nums.size - 2) {
                var left = j + 1
                var right = nums.size - 1
                while (left < right) {
                    val sum = nums[i] + nums[j] + nums[left] + nums[right]
                    when {
                        sum == target -> {
                            set.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                            left++
                            right--
                        }
                        sum < target -> left++
                        sum > target -> right--
                    }
                }
            }
        }

        return set.toList()
    }
}