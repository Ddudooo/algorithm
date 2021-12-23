package study.problem.kt

public class Solution {
    private companion object {
        private const val PLACE_HOLDER_MULTIPLE = '*'
        private const val PLACE_HOLDER_SINGLE = '.'
    }

    fun isMatch(s: String, p: String): Boolean {
        val lenS = s.length
        val lenP = p.length

        val dp = Array(lenS + 1) { BooleanArray(lenP + 1) { false } }
        dp[0][0] = true

        for (idxP in 0 until lenP) {
            if (p[idxP] == PLACE_HOLDER_MULTIPLE && dp[0][idxP - 1]) {
                dp[0][idxP + 1] = true
            }
        }

        for (idxS in 0 until lenS) {
            for (idxP in 0 until lenP) {
                if (p[idxP] == PLACE_HOLDER_SINGLE) {
                    dp[idxS + 1][idxP + 1] = dp[idxS][idxP]
                }

                if (p[idxP] == s[idxS]) {
                    dp[idxS + 1][idxP + 1] = dp[idxS][idxP]
                }

                if (p[idxP] == PLACE_HOLDER_MULTIPLE) {
                    if (p[idxP - 1] != s[idxS] && p[idxP - 1] != PLACE_HOLDER_SINGLE) {
                        dp[idxS + 1][idxP + 1] = dp[idxS + 1][idxP - 1]
                    } else {
                        dp[idxS + 1][idxP + 1] =
                            (dp[idxS + 1][idxP] || dp[idxS][idxP + 1] || dp[idxS + 1][idxP - 1])
                    }
                }
            }
        }

        return dp[lenS][lenP]
    }
}