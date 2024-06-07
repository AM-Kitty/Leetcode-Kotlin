import java.io.*;
import java.util.*;

/**
String
 */

fun wordTyping(sentence: Array<String>, rols: Int, maxScreenWidth:Int):Int{
  // add spaces between string and even next line
  val formatStr = sentence.joinToString(" ") + " "
  val entireStrSize = formatStr.length
  var remainRows = rols
  var cur = 0

  while (remainRows >0){
    cur += maxScreenWidth
    // if current character is space, start from the next word
    if (formatStr[cur % entireStrSize] == ' '){
      cur ++
    } else {
      // if it is inside a word, move backword to the beginning of that word
      while(cur > 0 && formatStr[(cur-1) % entireStrSize] != ' '){
        cur --
      }
    }
    remainRows --
  }
  return cur / entireStrSize
}

fun main() {
  val s = arrayOf("i", "had", "apple", "pie")
  println(wordTyping(s, 4, 5))  // -> 1

  val s1 = arrayOf("a", "bcd", "e")
  print(wordTyping(s1, 3, 6))   // -> 2
}
