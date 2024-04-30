class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        // Keywords: PQ, sorting
        val res = mutableListOf<IntArray>()

        // 2nd approach to use the PQ
        // val sortedQueue = PriorityQueue<IntArray>(compareBy{it[0]})

        intervals.sortBy { it[0] }
        var nextInterval = intervals[0]

        for (period in 1..intervals.size-1){
            val cur = intervals[period]
            if (maxOf(cur[0], nextInterval[0]) <= minOf(cur[1], nextInterval[1])){
                nextInterval = intArrayOf(
                    minOf(cur[0], nextInterval[0]),
                    maxOf(cur[1], nextInterval[1])
                )
            } else {
                res.add(nextInterval)
                nextInterval = intArrayOf(cur[0], cur[1])
            }
        }
        res.add(nextInterval)
        // cast from mutable list to array
        return res.toTypedArray()
    }
}