package study.problem.kt

class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = dfs(numbers, target)
        return answer
    }

    private fun dfs(numbers: IntArray, target: Int, index: Int = 0, sum: Int = 0): Int {
        return if (index == numbers.size) {
            isEqualTargetSum(target, sum)
        } else {
            dfs(numbers, target, index + 1, sum + numbers[index]) + dfs(
                numbers,
                target,
                index + 1,
                sum - numbers[index]
            )
        }
    }

    private fun isEqualTargetSum(target: Int, sum: Int): Int = if (target == sum) 1 else 0
}