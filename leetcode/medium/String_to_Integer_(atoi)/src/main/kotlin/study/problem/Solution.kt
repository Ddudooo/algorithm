package study.problem

class Solution {
    fun myAtoi(s: String): Int {
        val trimStr = s.trim()
        var signFlag = false
        var sign = 1
        val sb = StringBuffer()
        for (i in trimStr.toCharArray()) {
            if (i == '-' || i == '+') {
                if (sb.isNotEmpty()) break
                if (!signFlag) {
                    signFlag = true
                } else {
                    break
                }
                sign = if (i == '-') -1 else 1
            } else if (i.isDigit()) {
                sb.append(i)
            } else {
                break
            }
        }
        return parsingInt(sb, sign)
    }

    private fun parsingInt(sb: StringBuffer, sign: Int): Int {
        if (sb.isEmpty()) return 0

        try {
            return sign * sb.toString().toInt()
        } catch (e: Exception) {
            return if (sign > 0) Int.MAX_VALUE else Int.MIN_VALUE
        }
    }
}