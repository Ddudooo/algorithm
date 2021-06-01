package study.problem.kt

class Solution {
    fun solution(numbers: IntArray, target: Int): Int = dfs(numbers, target)

    private fun dfs(numbers: IntArray, target: Int): Int =
        numbers.fold(listOf(0)) { list, number ->
            list.run {
                map { it + number } + map { it - number }
            }
        }.count { it == target }
}