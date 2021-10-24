package study.problem

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

internal class SolutionTest {
    private var solution = Solution()

    @BeforeEach
    fun init() {
        solution = Solution()
    }

    @ParameterizedTest
    @CsvSource(
        "[1,8,6,2,5,4,8,3,7]\t49",
        "[1,1]\t1",
        "[4,3,2,1,4]\t16",
        "[1,2,1]\t2",
        delimiter = '\t'
    )
    fun testCase(inputArrayStr: String, expect: Int) {
        val answer = solution.maxArea(strToIntAry(inputArrayStr))

        assertEquals(expect, answer, "답이 같아야 한다.")
    }

    private fun strToIntAry(str: String): IntArray {
        return str.split(',')
            .stream()
            .map { s -> s.replace("\\D".toRegex(), "").trim() }
            .mapToInt(String::toInt)
            .toArray()
    }
}