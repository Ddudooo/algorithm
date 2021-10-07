package study.problem.kt

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.opentest4j.AssertionFailedError
import java.util.*
import kotlin.test.BeforeTest

internal class SolutionTest {
    var solution = Solution()

    @BeforeTest
    fun init() {
        solution = Solution()
    }

    @ParameterizedTest
    @CsvSource(
        "[2,4,3]\t[5,6,4]\t[7,0,8]",
        "[0]\t[0]\t[0]",
        "[9,9,9,9,9,9,9]\t[9,9,9,9]\t[8,9,9,9,0,0,0,1]", delimiter = '\t'
    )
    fun testCase(l1Str: String, l2Str: String, resultStr: String) {
        val answer = solution.addTwoNumbers(strToListNode(l1Str), strToListNode(l2Str))
        var temp = answer
        while (temp != null) {
            print("${temp.`val`}")
            temp = temp.next
        }
        println()
        assertListNodeEquals(strToListNode(resultStr), answer!!)
    }

    private fun strToListNode(str: String): ListNode {
        val ary: IntArray = strToIntAry(str)
        val result: ListNode = ListNode(0)
        var cursor = result
        val queue: Queue<Int> = LinkedList()
        Arrays.stream(ary).forEach { e: Int -> queue.add(e) }
        while (!queue.isEmpty()) {
            val value = queue.poll()
            cursor.`val` = value
            if (!queue.isEmpty()) {
                cursor.next = ListNode(0)
                cursor = cursor.next!!
            }
        }
        return result
    }

    private fun strToIntAry(str: String): IntArray {
        val split = str.split(",").toTypedArray()
        return Arrays.stream(split)
            .map { s: String ->
                s.replace(
                    "\\D".toRegex(),
                    ""
                )
            }
            .map(String::trim)
            .mapToInt(Integer::parseInt)
            .toArray()
    }

    private fun assertListNodeEquals(
        expect: ListNode,
        answer: ListNode
    ) {
        var expect = expect
        var answer = answer
        val flag = true
        while (flag) {
            try {
                val expectVal = expect.`val`
                val answerVal = answer.`val`
                assertEquals(expectVal, answerVal)
                if (expect.next == null && answer.next == null) {
                    return
                }
                expect = expect.next!!
                answer = answer.next!!
            } catch (e: Exception) {
                throw AssertionFailedError("not matched expected value!")
            }
        }
    }
}