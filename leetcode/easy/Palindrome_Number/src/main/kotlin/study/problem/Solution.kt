package study.problem

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false

        if (x < 10) return true
        var temp = x;
        var reverse: Int = 0
        try {
            while (temp > 0) {
                reverse = reverse * 10 + temp % 10
                temp /= 10
            }
            return reverse == x
        } catch (e: Exception) {
            return false
        }
    }
}