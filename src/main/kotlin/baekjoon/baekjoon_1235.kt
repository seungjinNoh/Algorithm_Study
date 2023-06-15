package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val list = mutableListOf<String>()

    repeat(n) {
        list.add(readLine().reversed())
    }

    val set = mutableSetOf<String>()
    val size = list.first().length

   for (i in 0 until size) {
       for (j in 0 until n) {
           val str = list[j].substring(0, i)
           if (set.contains(str)) {
               set.clear()
               break
           }
           set.add(str)
           if (j == n - 1) {
               println(i + 1)
               return@with
           }
       }
   }
}