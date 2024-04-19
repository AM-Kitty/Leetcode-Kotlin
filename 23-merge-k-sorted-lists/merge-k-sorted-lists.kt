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
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        // Keywords: PQ (heap)
        if (lists.size == 0) return null

        val dummyHead = ListNode(0)
        var curTail = dummyHead

        val nodePq = PriorityQueue<ListNode>(compareBy{it.`val`})
        for (ll in lists){
            // null pointer exception handler
            ll?.let{ nodePq.add(ll) }
        }

        while(nodePq.isNotEmpty()){
            // poll in the entire linked list
            val minNode = nodePq.poll()

            // add the rest of the polled linked list back
            minNode.next?.let{ nodePq.add(it)}

            curTail.next = minNode
            curTail = curTail.next
        }
        return dummyHead.next
    }
}