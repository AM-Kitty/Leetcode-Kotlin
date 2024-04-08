/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    // LinkedList
    // Kotlin does not support LinkedList 
    // Create a ListNode data class

    // Keywords: reverse adding 

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        var cur = dummyHead

        var p = l1
        var q = l2

        var rem = 0
        
        while(p != null || q!= null){
            val l1Res = p?.`val` ?: 0
            val l2Res = q?.`val` ?: 0

            val temp = l1Res + l2Res + rem
            rem = (temp) /10
            val res = (temp) % 10

            cur.next = ListNode(res)
            cur = cur.next

            if (p != null) p = p.next
            if (q != null) q = q.next 

        }

        if (rem>0){
            cur.next = ListNode(rem)
        }

        return dummyHead.next
    }
}