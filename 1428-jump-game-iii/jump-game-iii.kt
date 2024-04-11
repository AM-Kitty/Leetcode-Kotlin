class Solution {
    fun canReach(arr: IntArray, start: Int): Boolean {
        // Keywords: BFS
        
        val queue = LinkedList<Int>()
        val visited = HashSet<Int>()
        val n = arr.size

        queue.offer(start)
        visited.add(start)

        while(queue.isNotEmpty()){
            val node = queue.poll()

            if(arr[node]==0){
                return true
            }

            val nextNodeOne = node+arr[node]
            val nextNodeTwo = node-arr[node]
            
            if(nextNodeOne < n && !visited.contains(nextNodeOne)){
                queue.offer(nextNodeOne)
                visited.add(nextNodeOne)
            }

            if(nextNodeTwo >= 0 && !visited.contains(nextNodeTwo)){
                queue.offer(nextNodeTwo)
                visited.add(nextNodeTwo)
            }


        }
        return false
    }
}