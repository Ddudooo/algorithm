package study.problem.kt

class Solution {
    fun longestPalindrome(s: String): String {
        if (s.length < 2) return s
        var size = s.length
        var start: Int
        var end: Int
        while (size > 1) {
            start = 0
            end = size - 1
            while (end < s.length) {
                if (isPalindrome(s, start, end)) return s.substring(start..end)
                start++
                end++
            }
            size--
        }
        return s[0].toString()
    }

    private fun isPalindrome(s: String, start: Int, end: Int): Boolean {
        var left = start
        var right = end
        while (left < right) {
            if (s[left++] != s[right--]) return false
        }
        return true
    }
}