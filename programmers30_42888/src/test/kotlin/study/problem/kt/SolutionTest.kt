package study.problem.kt

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import study.problem.Solution

class SolutionTest {
    @Test
    fun test1() {
        val solution = Solution()
        val answer = solution.solution(
            arrayOf(
                "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
                "Enter uid1234 Prodo", "Change uid4567 Ryan"
            )
        )

        for (output in answer) {
            println(output)
        }

        assertArrayEquals(
            arrayOf(
                "Prodo님이 들어왔습니다.",
                "Ryan님이 들어왔습니다.",
                "Prodo님이 나갔습니다.",
                "Prodo님이 들어왔습니다."
            ), answer, "정답 확인!"
        )
    }
}