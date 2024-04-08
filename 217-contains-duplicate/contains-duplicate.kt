class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val hashSetNums = nums.toHashSet()

        return hashSetNums.size != nums.size

    }
}