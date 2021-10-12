package study.problem.kt

class Solution {
    fun reverse(x: Int): Int {
        try {
            return if (x >= 0) {
                x.toString().reversed().toInt()
            } else {
                var num = x.toString().drop(1).reversed().toInt()
                num -= num * 2
                num
            }
        } catch (e: Exception) {
            return 0
        }
    }
}