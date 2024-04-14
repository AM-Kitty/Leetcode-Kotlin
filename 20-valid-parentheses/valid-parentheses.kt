class Solution {
    fun isValid(s: String): Boolean {
        val charMap = mapOf(
            ')' to '(',
            ']' to '[',
            '}' to '{'
        )

        val stack = Stack<Char>()
        for (c in s){
            val openBraket = charMap[c]
            if (openBraket != null && stack.isNotEmpty() && stack.peek() == openBraket){
                stack.pop()
            } else {
                stack.push(c)
            }
        }

        return stack.isEmpty()
    }
}