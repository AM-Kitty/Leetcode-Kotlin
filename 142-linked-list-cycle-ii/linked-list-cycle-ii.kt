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
    fun detectCycle(head: ListNode?): ListNode? {
        // Keywords: HashSet
        
        if(head == null || head?.next == null){
            return null
        }

        var cur = head
        var storedValueSet = hashSetOf<ListNode>()

        while(cur?.next != null){
            if(storedValueSet.contains(cur)){
                return cur
            }
            storedValueSet.add(cur)
            cur = cur?.next
        }

        return null
        
    }
}