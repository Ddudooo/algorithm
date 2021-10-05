package study.problem

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({
    var solution: Solution = Solution()

    beforeEach {
        solution = Solution()

    }

    test("'121'는 'true'를 반환해야 한다") {
        with(solution) { isPalindrome(121).shouldBe(true) }
    }
})
