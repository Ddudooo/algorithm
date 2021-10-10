package study.problem.kt

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class SolutionTest {
    private var solution: Solution = Solution()

    @BeforeEach
    fun init() {
        solution = Solution()
    }

    @ParameterizedTest
    @CsvSource(
        "babad\tbab",
        "cbbd\tbb",
        "a\ta",
        "ac\ta", delimiter = '\t'
    )
    fun testCase(s: String, expect: String) {
        val answer = solution.longestPalindrome(s)

        assertEquals(expect, answer, "답이 같아야 한다.")
    }
}