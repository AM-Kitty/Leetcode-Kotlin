class Solution {
    fun countAndSay(n: Int): String {
        // Keywords: Recursion
        
        if(n == 1) return "1"

        val previous = countAndSay(n - 1)
        
        val stringBuilder = StringBuilder()
        var count = 0
        var num = ' '

        for(i in 0 until previous.length) {
            if(num == ' ') {
                count++
                num = previous[i]
                continue
            } 
            
             if(num == previous[i]) {
                count++
            } else {
                 stringBuilder.append("$count$num")
                 num = previous[i]
                 count = 1
            }
        }

        stringBuilder.append("$count$num")

        return stringBuilder.toString()
    }
}