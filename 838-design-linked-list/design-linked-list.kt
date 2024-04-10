data class Node(
    val value: Int, 
    var next: Node? = null
)

class MyLinkedList() {
    
    private var cur: Node? = null
    private var head: Node? = null
    
    private var size = 0

    fun get(index: Int): Int {
        var cur_idx = 0
        if (head == null || index >= size){
            return -1
        }

        cur = head

        while(cur_idx != index && cur?.next != null){
            cur_idx ++
            cur = cur?.next
        }
        
        if (cur_idx == index){
            return cur?.value ?: -1
        } else {
            return -1
        }
    }
    //= getNode(index)?.value ?: -1

    private fun getNode(index: Int): Node? {
        var i=0
        cur = head
        while(i++ < index && cur?.next != null) {
            cur = cur?.next
        }
        if(--i==index) return cur
        else return null
    }

    fun addAtHead(`val`: Int) {
        if(head == null) head = Node(`val`)
        else {
            cur = head
            head = Node(`val`, next = cur)
        }

        size++
    }

    fun addAtTail(`val`: Int) {
        if(head == null) {
            addAtHead(`val`)
            return
        }
        
        cur = head
        while (cur?.next != null) cur = cur?.next

        cur?.next = Node(`val`)

        size++
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if(index > size || index < 0) return
        if(index == 0) {
            addAtHead(`val`)
            return
        }

        cur = head
        var cur_idx = 0

        while(cur_idx != index-1 && cur?.next != null){
            cur_idx ++
            cur = cur?.next
        }

       
        val temp = cur
        cur?.next = Node(`val`, next = temp?.next)

        size++
    }

    fun deleteAtIndex(index: Int) {
        if(size == 0 || index > size || index < 0) return
        if(index == 0) {
            head = head?.next
            return
        }

        cur = head
        var cur_idx = 0
        while(cur_idx != index-1 && cur?.next != null){
            cur_idx ++
            cur = cur?.next
        }
        cur?.next = cur?.next?.next
    }
}