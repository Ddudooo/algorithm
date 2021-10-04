package study.problem

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({
    var solution: Solution = Solution()

    beforeEach { solution = Solution() }

    test("'42'는 '42'를 반환해야 한다") {
        with(solution) { myAtoi("42").shouldBe(42) }
    }

    /*
    TODO: Kotest 매개변수 테스트 확인하기.
    listOf(
        "42" to 42,
    ).forEach { (input: String, expect: Int) ->
        with(solution) {
            myAtoi(input).shouldBe(expect)
        }
    }
    */
})