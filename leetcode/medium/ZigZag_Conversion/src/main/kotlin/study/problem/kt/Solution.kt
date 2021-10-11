package study.problem.kt

class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        val matrix = Array(numRows) { StringBuilder() }
        var direct = true
        var current = 0
        for (char in s) {
            matrix[current].append(char)
            if (current == numRows - 1) direct = false
            if (current == 0) direct = true
            if (direct) current++ else current--
        }
        return matrix.joinToString("")
    }
}