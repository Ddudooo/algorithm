package study.problem.kt

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {

        val sortedList = strs.sorted()
        val (first, last) = sortedList.first() to sortedList.last()
        val shortLastIndex =
            if (first.lastIndex < last.lastIndex) first.lastIndex else last.lastIndex

        var commonPrefixCount = 0

        for (i in 0..shortLastIndex) {
            if (first[i] != last[i]) break

            // now time to increase
            ++commonPrefixCount
        }

        return first.substring(0, commonPrefixCount)
    }
}