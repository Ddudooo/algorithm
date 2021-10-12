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
        "123\t321",
        "-123\t-321",
        "123\t321",
        "0\t0", delimiter = '\t'
    )
    fun testCase(x: Int, expect: Int) {
        val answer = solution.reverse(x)

        assertEquals(expect, answer, "답이 같아야 한다.")
    }

}