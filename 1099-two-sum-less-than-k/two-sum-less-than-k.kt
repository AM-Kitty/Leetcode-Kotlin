import java.io.*;
import java.util.*;

// To execute Kotlin code, please define a top level function named main

// Given an array A of integers and integer K, return the maximum S such that there exists i < j with A[i] + A[j] = S and S < K. If no i, j exist satisfying this equation, return -1.

// Input: A = [34,23,1,24,75,33,54,8], K = 60
// Output: 58
// Explanation: 
// We can use 34 and 24 to sum 58 which is less than 60.

fun twoSumLessThan(nums: IntArray, k:Int):Int{
  val storedSet = HashSet<Int>()
  val n = nums.size

  for (i in 0..n){
    var j = 0 
    while(j + i < n){
      val num1 = nums[i]
      val num2 = nums[j]
      print(num1)
      println(num2)
      val total = num1 + num2

      if (!storedSet.contains(total) && total < k && i!=j) {
        storedSet.add(total)
      }
      j++
    }
  }

  if (storedSet.isNotEmpty()){
    return storedSet.max()
  } else {
    return -1
  }

}

fun main() {
  val a = intArrayOf(34,23,1,24,75,33,54,8,9)
  val maxSum = twoSumLessThan(a,60)
  println("Result: $maxSum")  // Output -> 58
}
