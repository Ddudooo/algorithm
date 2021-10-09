package study.problem.kt

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.util.*
import kotlin.test.assertEquals

internal class SolutionTest {
    private var solution = Solution()

    @BeforeEach
    fun init() {
        solution = Solution()
    }

    @ParameterizedTest
    @CsvSource(
        "[1,3]\t[2]\t2.00000",
        "[1,2]\t[3,4]\t2.50000",
        "[0,0]\t[0,0]\t0.00000",
        "[]\t[1]\t1.00000",
        "[2]\t[]\t2.00000",
        delimiter = '\t'
    )
    fun testCase(num1Str: String, num2Str: String, expect: Double) {
        val answer =
            solution.findMedianSortedArrays(strToIntAry(num1Str), strToIntAry(num2Str))

        assertEquals(expect, answer, "답이 같아야 한다.")
    }

    private fun strToIntAry(str: String): IntArray {
        val split = str.split(",").toTypedArray()
        return if (split[0].replace("\\D".toRegex(), "").trim { it <= ' ' }.isEmpty()) {
            intArrayOf()
        } else Arrays.stream(split)
            .map { s: String ->
                s.replace(
                    "\\D".toRegex(),
                    ""
                )
            }
            .map(String::trim)
            .mapToInt(Integer::valueOf)
            .toArray()
    }
}