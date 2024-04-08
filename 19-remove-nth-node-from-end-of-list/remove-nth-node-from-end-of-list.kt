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
    // Keyword: Two pointers

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
       val dummyHead = ListNode(0)
       dummyHead.next = head
       var l: ListNode? = dummyHead
       var r: ListNode? = dummyHead

       for(i in 0..n) {
        r = r?.next
       } 

       while(r!= null){
        l = l?.next
        r = r?.next
       }

       l?.next = l?.next?.next
       return dummyHead.next

    }
}