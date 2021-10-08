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
        "abcabcbb\t3",
        "bbbbb\t1",
        "pwwkew\t3",
        delimiter = '\t'
    )
    fun testCase(input: String, expect: Int) {
        val answer = solution.lengthOfLongestSubstring(input)

        assertEquals(expect, answer, "답이 같아야 한다.")
    }
}