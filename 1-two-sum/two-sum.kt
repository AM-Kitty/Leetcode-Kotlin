class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // Keywords: HashMap
        
        var storedSet = HashMap<Int, Int>()
        var res = mutableListOf<Int>()

        for (i in nums.indices){
            storedSet[nums[i]] = i
        }

        for (i in nums.indices){
            val second = storedSet.get(target - nums[i])

            // Second condition restricts from using the same element twice
            if (second!= null && (second ?: -1 > i)){
                res.add(i)
                res.add(second)
            }
        }
        return res.toIntArray()
    }
}