package study.problem.kt

class Solution {
    val alphabetsToNumber = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )
    val temp = mutableListOf<String>()
    val result = mutableListOf<String>()
    fun letterCombinations(digits: String): List<String> {
        for (d in digits) {
            temp += alphabetsToNumber.getValue(d)
        }
        if (temp.size > 0) {
            combinator(temp, 0, "")
        }
        return result
    }

    fun combinator(temp: List<String>, i: Int, res: String) {
        if (i == temp.size) {
            result += res
            return
        }
        for (right in temp[i]) {
            combinator(temp, i + 1, res + right)
        }
    }
}