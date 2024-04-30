class Solution {
    fun myPow(x: Double, n: Int): Double {
        // Keywords: Math
        // Complexity: O(N)
        if (n == 0) return 1.0
        val baseNum: Double = if(n<0) 1/x else x
        var product: Double = baseNum
        var res: Double = 1.0
        var exponent: Long = abs(n.toLong())

        while(exponent > 0){
            if (exponent % 2 == 1L){
                res = res * product
            }
            product = product * product
            exponent = exponent /2
        }

        return res

    }
}