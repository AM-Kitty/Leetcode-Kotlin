class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        // Keywords: HashSet

        if (nums.size == 0) return 0

        val numsSet = nums.toHashSet()
        var res = 0

        for(num in nums){
            // only number starts no left consecutive number is the smallest 
            // starting number
            if(!numsSet.contains(num-1)){
                var curSmallestAvailNum = num
                var curCount = 1
                
                // based on the current number, find the next available number
                while (numsSet.contains(curSmallestAvailNum+1)){
                    curSmallestAvailNum++
                    curCount ++
                }
                res = maxOf(res, curCount)
            }
            
        }

        return res
    }
}