class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        // Keywords: HashMap (NO duplicate keys allowed); 
        // Sliding window (width)

        var stringIndexSet = HashMap<Char,Int>()
        var last = -1
        var res = 0
        
        for(i in s.indices){
            // getOrElse in Map function 
            // get s[i] otherwise returns -1
            last = maxOf(last, stringIndexSet.getOrElse(s[i], {-1}))
            // if the value does not exist, current index -(-1)
            // otherwise, won't increase by 1
            res = maxOf(res, i-last)
            // create the hashmap after checking the last occurence
            stringIndexSet[s[i]] = i
        }
        return res
    }
}