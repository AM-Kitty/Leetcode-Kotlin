class Solution {
    // Keywords: Math, Array

    fun indexHelper(index:Int, n:Int):Int{
        if (index <0) {
            return n- Math.abs(index)
        } else {
            return index
        }

    }

    fun rotate(nums: IntArray, k: Int): Unit {
        val n = nums.size
        var res = IntArray(n)
        val right_rotation = k % n

        for(i in 0..n-1){
            val updatedIndex = indexHelper(i - right_rotation, n)
            res[i] = nums[updatedIndex]
        }

        for(i in 0..n-1){
            nums[i] = res[i]
        }
    }
}