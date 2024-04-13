class Solution {
    fun canReach(arr: IntArray, start: Int): Boolean {
        // Keywords: BFS

        val visited = HashSet<Int>()
        val queue = LinkedList<Int>()
        val n = arr.size

        queue.offer(start)
        visited.add(start)

        while(queue.isNotEmpty()){
            val cur = queue.poll()
            if(arr[cur] == 0){
                return true
            }

            val nextNodeOne = cur + arr[cur]
            val nextNodeTwo = cur - arr[cur]

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