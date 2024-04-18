class Solution {
    fun findLengthOfLCIS(nums: IntArray): Int {
        // Keywords: Math

        if(nums.size == 0) return 0
        var res = 1
        var count = 1
        
        for (i in nums.indices){
            if ((i+1) < nums.size){
                if (nums[i+1] > nums[i]){
                    count ++
                    res = maxOf(res, count)
                } else {
                    count = 1
                }
            }
        }
        return res
    }
}