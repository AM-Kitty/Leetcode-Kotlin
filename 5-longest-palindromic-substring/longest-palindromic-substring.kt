class Solution {
    fun longestPalindrome(s: String): String {
        /*
        Two Pointers
         */

        if (s.isEmpty()) return ""

        var start = 0
        var maxLength = 0

        fun expandAroundCenter(left: Int, right: Int) {
            var l = left
            var r = right
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                if (r - l + 1 > maxLength) {
                    start = l
                    maxLength = r - l + 1
                }
                l--
                r++
            }
        }

        for (i in s.indices) {
            // Check for odd-length palindromes
            /*
            These have a single center character. For example, in the string
            "racecar", the palindrome "racecar" has the center character 'e'. 
            The palindrome is symmetric around this single character
             */
            expandAroundCenter(i, i)
            // Check for even-length palindromes
            /*
            These have two center characters. For example, in the string "abba", 
            the palindrome "abba" has the center characters 'bb'. The palindrome 
            is symmetric around the pair of center characters.
             */
            expandAroundCenter(i, i + 1)
        }

        return s.substring(start, start + maxLength)
    }
}