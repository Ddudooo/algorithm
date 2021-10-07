package study.problem.kt

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val result = ListNode(0)
        var cursor: ListNode = result
        var up = 0
        var list1 = l1;
        var list2 = l2;
        while (list1 != null && list2 != null) {
            var temp = list1.`val` + list2.`val` + cursor.`val`
//            println("list1 [${list1.`val`}] + list2 [${list2.`val`}] +up [${cursor.`val`}] = $temp")
            cursor.`val` = temp % 10
            up = temp / 10
            list1 = list1.next
            list2 = list2.next
//            println("result val = [${cursor.`val`}], up = $up")
            if (list1 != null || list2 != null || up != 0) {
                cursor.next = ListNode(up)
                cursor = cursor.next!!
            }
        }

        while (list1 != null) {
            val temp = list1.`val` + cursor.`val`
            cursor.`val` = temp % 10
            up = temp / 10

            list1 = list1.next
            if (list1 != null || up != 0) {
                cursor.next = ListNode(up)
                cursor = cursor.next!!
            }
        }
        while (list2 != null) {
            val temp = list2.`val` + cursor.`val`
            cursor.`val` = temp % 10
            up = temp / 10

            list2 = list2.next
            if (list2 != null || up != 0) {
                cursor.next = ListNode(up)
                cursor = cursor.next!!
            }
        }
        return result
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}