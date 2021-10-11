package study.problem.kt

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

internal class SolutionTest {
    private var solution: Solution = Solution()

    @BeforeEach
    fun init() {
        solution = Solution()
    }

    @ParameterizedTest
    @CsvSource(
        "PAYPALISHIRING\t3\tPAHNAPLSIIGYIR",
        "PAYPALISHIRING\t4\tPINALSIGYAHRPI",
        "A\t1\tA",
        delimiter = '\t'
    )
    fun testCase(s: String, numRows: Int, expect: String) {
        val answer = solution.convert(s, numRows)

        assertEquals(expect, answer, "답이 같아야 한다.")
    }
}