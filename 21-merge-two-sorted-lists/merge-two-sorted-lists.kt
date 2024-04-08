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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        // use the current pointer to move to NEXT node
        var cur = dummyHead

        var node1 = list1
        var node2 = list2

        while(node1 != null || node2 != null){
            // handle null cases first, so no need to check nullable
            // in the following
            if (node1 == null){
                cur.next = node2
                break
            } else if (node2 == null){
                cur.next = node1
                break
            }
            
            if (node1.`val` < node2.`val`){
                cur.next = node1 
                node1 = node1.next
            } else {
                cur.next = node2 
                node2 = node2.next
            }

            cur = cur.next
        }

        return dummyHead?.next
        
    }
}