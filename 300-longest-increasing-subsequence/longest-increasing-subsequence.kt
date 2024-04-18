class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        // Keywords: Binary Search (remains a sorted ascending order)

        if (nums.size == 0) return 0

        val subSet = mutableListOf<Int>()
        var res = 1

        for (num in nums){
            if (subSet.isEmpty()){
                subSet.add(num)
            } else {
                var supposedToAddIdx = subSet.binarySearch(num)
                // if the num not found based on the binary search algorithm
                // find the supposed to add index
                if (supposedToAddIdx < 0){
                    supposedToAddIdx = -(supposedToAddIdx + 1)
                }
                if (supposedToAddIdx == subSet.size){
                    subSet.add(num)
                } else {
                    subSet[supposedToAddIdx] = num
                }
            }
        }
        return subSet.size
    }
}