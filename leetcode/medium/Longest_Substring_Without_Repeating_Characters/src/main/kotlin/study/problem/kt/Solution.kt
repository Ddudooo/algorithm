package study.problem.kt

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length < 2) return s.length
        val chars = s.toCharArray()
        val checked = mutableSetOf<Char>()
        var start = 0
        var end = 0
        var max = 0
        while (start <= end) {
            if (checked.add(chars[end])) {
                end++
                max = max(max, checked.size)
                if (end >= chars.size) break
            } else {
                checked.remove(chars[start++])
            }
        }
        return max
    }
}