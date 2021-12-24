class Solution {
    fun intToRoman(num: Int): String {

        var answer: String = ""
        var number: Int = num

        if (num < 1 || num > 3999) {
            return ""
        }
        while (number > 0) {

            val divisor: Int = getDivisor(number = number)
            answer += appendRomanSymbol(
                romanValue = getRomanSymbol(value = divisor),
                repeat = number / divisor
            )
            number %= divisor

        }

        return answer
    }

    private fun getRomanSymbol(value: Int): String {
        when (value) {
            1 -> return "I"
            4 -> return "IV"
            5 -> return "V"
            9 -> return "IX"
            10 -> return "X"
            40 -> return "XL"
            50 -> return "L"
            90 -> return "XC"
            100 -> return "C"
            400 -> return "CD"
            500 -> return "D"
            900 -> return "CM"
            1000 -> return "M"
            else -> throw IllegalArgumentException()
        }
    }

    private fun appendRomanSymbol(romanValue: String, repeat: Int): String {

        var replacementString: String = ""

        for (i in 1..repeat) {
            replacementString += romanValue
        }

        return replacementString
    }

    private fun getDivisor(number: Int): Int {
        when {
            number >= 1000 -> return 1000
            number >= 900 -> return 900
            number >= 500 -> return 500
            number >= 400 -> return 400
            number >= 100 -> return 100
            number >= 90 -> return 90
            number >= 50 -> return 50
            number >= 40 -> return 40
            number >= 10 -> return 10
            number >= 9 -> return 9
            number >= 5 -> return 5
            number >= 4 -> return 4
            number >= 1 -> return 1
            else -> throw IllegalArgumentException()
        }
    }
}