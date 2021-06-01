package study.problem.kt

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun dfsTest() {
        val solution = Solution()
        val answer = solution.solution(intArrayOf(1, 1, 1, 1, 1), 3)

        assertEquals(5, answer, "답은 5임.")
    }
}