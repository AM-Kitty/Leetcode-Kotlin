
class MKAverage(m: Int, k: Int) {
    private val q = LinkedList<Int>()
    private val top = TreeMap<Int, Int>()
    private val mid = TreeMap<Int, Int>()
    private val bot = TreeMap<Int, Int>()
    private var topSize = 0
    private var botSize = 0
    private var midSum: Long = 0

    val m = m
    val k = k

    fun addElement(num: Int) {
        q.offer(num)
        add(mid, num)
        midSum += num

        if (q.size > m) {
            val removed = q.poll()
            when {
                top.containsKey(removed) -> {
                    remove(top, removed)
                    topSize--
                }
                mid.containsKey(removed) -> {
                    remove(mid, removed)
                    midSum -= removed
                }
                else -> {
                    remove(bot, removed)
                    botSize--
                }
            }
        }

        while (!mid.isEmpty() && topSize < k) {
            midSum -= mid.lastKey()
            add(top, remove(mid, mid.lastKey()))
            topSize++
        }

        while (!mid.isEmpty() && mid.lastKey() > top.firstKey()) {
            midSum -= mid.lastKey()
            midSum += top.firstKey()
            add(top, remove(mid, mid.lastKey()))
            add(mid, remove(top, top.firstKey()))
        }

        while (!mid.isEmpty() && botSize < k) {
            midSum -= mid.firstKey()
            add(bot, remove(mid, mid.firstKey()))
            botSize++
        }

        while (!mid.isEmpty() && mid.firstKey() < bot.lastKey()) {
            midSum -= mid.firstKey()
            midSum += bot.lastKey()
            add(bot, remove(mid, mid.firstKey()))
            add(mid, remove(bot, bot.lastKey()))
        }
    }

    fun calculateMKAverage(): Int {
        return if (q.size == m) (midSum / (m - 2 * k)).toInt() else -1
    }

    private fun add(map: TreeMap<Int, Int>, num: Int) {
        // The value to be associated with the key num is 1 if the key does not already exist 
        // in the TreeMap.
        // The lambda function returns the new value to be associated with the key after merging. 
        // In this case, we increment the current value by 1 and return the result.
        map.merge(num, 1) { oldVal, _ -> oldVal + 1 }
    }

    private fun remove(map: TreeMap<Int, Int>, num: Int): Int {
        map[num] = map.getOrDefault(num, 0) - 1
        if (map[num] == 0) {
            map.remove(num)
        }
        return num
    }
}
