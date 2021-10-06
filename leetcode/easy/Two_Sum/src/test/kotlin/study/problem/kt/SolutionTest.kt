package study.problem.kt

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.BeforeTest

internal class SolutionTest {
    private var solution: Solution = Solution()

    @BeforeTest
    fun init() {
        solution = Solution()
    }

    @ParameterizedTest
    @CsvSource(
        "[2,7,11,15]\t9\t[0,1]",
        "[3,2,4]\t6\t[1,2]",
        "[3,3]\t6\t[0,1]", delimiter = '\t'
    )
    fun `two Sum input`(input: String, target: Int, expect: String) {
        val answer = solution.twoSum(strToIntAry(input), target);

        assertArrayEquals(strToIntAry(expect), answer, "답이 같아야 한다.")
    }

    private fun strToIntAry(str: String): IntArray {
        return str.split(',')
            .stream()
            .map { s -> s.replace("\\D".toRegex(), "").trim() }
            .mapToInt(String::toInt)
            .toArray()
    }
}