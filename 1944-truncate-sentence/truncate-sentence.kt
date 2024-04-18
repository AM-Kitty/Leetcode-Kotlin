class Solution {
    fun truncateSentence(s: String, k: Int): String {
        // Keywords: String
        
        val stringList = s.split(" ")
        val res = mutableListOf<String>()
        var finalStr = ""

        for (i in 0..k-1){
            res.add(stringList[i])
        }

        res.forEach{
          finalStr += it.toString()+ " "
        }
        return finalStr.trim()
    }
}