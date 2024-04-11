class Solution {
    fun isValid(s: String): Boolean {
        // Keywords: LIFO (stack) -> ArrayDeque
        if (s.length % 2 !=0){
            return false
        }

        val map = mapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
        )
        val stack = ArrayDeque<Char>()

        for(c in s){
            val openBracket = map[c]

            if (openBracket != null && stack.isNotEmpty() && stack.last() == openBracket){
                stack.removeLast()
            } else {
                stack.add(c)
            }

        }

        return stack.isEmpty()
    }
}