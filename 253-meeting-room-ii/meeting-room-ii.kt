import java.io.*;
import java.util.*;

// To execute Kotlin code, please define a top level function named main

// Keywords: Sorting
fun meetingRoom(times:List<List<Int>>):Int{
  var room = 0
  val sortStartTimes = times.map{it[0]}.sorted()
  val sortLastTimes = times.map{it[1]}.sorted()
  var startIndex = 0
  var endIndex = 0

  while (startIndex in sortStartTimes.indices){
    // the last meeting is not end/ready for the next meeting to start
    if (sortStartTimes[startIndex] <= sortLastTimes[endIndex]){
      room ++
      startIndex ++
    } else {
      startIndex ++
      endIndex ++
    }
  }
  return room

}

fun main() {
  val minRooms = listOf(
    listOf<Int>(0,30),
    listOf<Int>(5,10),
    listOf<Int>(15,20)
  )
  print(meetingRoom(minRooms)) //Output -> 2

}
